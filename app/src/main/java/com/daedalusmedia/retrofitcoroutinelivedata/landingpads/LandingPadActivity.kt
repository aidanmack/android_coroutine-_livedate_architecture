package com.daedalusmedia.retrofitcoroutinelivedata.landingpads

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.daedalusmedia.retrofitcoroutinelivedata.R
import com.daedalusmedia.retrofitcoroutinelivedata.api.LCE
import com.daedalusmedia.retrofitcoroutinelivedata.api.SpaceXLandingPadsData
import com.github.nitrico.lastadapter.BR
import com.github.nitrico.lastadapter.LastAdapter
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_landingpad.*

class LandingPadActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landingpad)
        supportActionBar?.title = resources.getString(R.string.landing_pads_title)

        val viewModel = ViewModelProviders.of(
            this,
            LandingPadsViewModelFactory()
        ).get(LandingPadViewModel::class.java)

        viewModel.show.observe(this, Observer { lce ->
            when (lce) {
                is LCE.Content -> {
                    landing_pads_progress.hide()
                    showPads(lce.content)
                }
                is LCE.Loading -> {
                    landing_pads_progress.show()
                }
                is LCE.Error -> {
                    landing_pads_progress.hide()
                    showError(lce.error)
                }
            }
        })
    }

    private fun showError(error: String) {
        Snackbar.make(landing_pads_root, error, Snackbar.LENGTH_LONG).apply {
            view.setBackgroundColor(ContextCompat.getColor(context, R.color.snackbarErrorBackground))
            show()
        }
    }

    private fun showPads(landingPads: List<SpaceXLandingPadsData>) {
        LastAdapter(landingPads, BR.item)
            .map<SpaceXLandingPadsData>(R.layout.item_landing_pad)
            .into(landing_pads_list)
    }
}
