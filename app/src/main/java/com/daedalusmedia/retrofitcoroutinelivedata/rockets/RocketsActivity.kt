package com.daedalusmedia.retrofitcoroutinelivedata.rockets

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.daedalusmedia.retrofitcoroutinelivedata.R
import com.daedalusmedia.retrofitcoroutinelivedata.api.LCE
import com.daedalusmedia.retrofitcoroutinelivedata.api.SpaceXRocketsData
import com.github.nitrico.lastadapter.BR
import com.github.nitrico.lastadapter.LastAdapter
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_rockets.*

class RocketsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rockets)
        supportActionBar?.title = resources.getString(R.string.rockets_title)

        val viewModel = ViewModelProviders.of(
            this,
            RocketsViewModelFactory()
        ).get(RocketsViewModel::class.java)

        viewModel.show.observe(this, Observer { lce ->
            when (lce) {
                is LCE.Content -> {
                    rockets_progress.hide()
                    showRockets(lce.content)
                }
                is LCE.Loading -> {
                    rockets_progress.show()
                }
                is LCE.Error -> {
                    rockets_progress.hide()
                    showError(lce.error)
                }
            }
        })
    }

    private fun showError(error: String) {
        Snackbar.make(rockets_root, error, Snackbar.LENGTH_LONG).apply {
            view.setBackgroundColor(ContextCompat.getColor(context, R.color.snackbarErrorBackground))
            show()
        }
    }

    private fun showRockets(rockets: List<SpaceXRocketsData>) {
        LastAdapter(rockets, BR.item)
            .map<SpaceXRocketsData>(R.layout.item_rocket)
            .into(rockets_list)
    }
}
