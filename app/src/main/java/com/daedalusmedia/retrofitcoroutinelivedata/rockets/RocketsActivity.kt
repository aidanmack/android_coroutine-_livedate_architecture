package com.daedalusmedia.retrofitcoroutinelivedata.rockets

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.daedalusmedia.retrofitcoroutinelivedata.R
import com.daedalusmedia.retrofitcoroutinelivedata.api.LCE

class RocketsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rockets)

        val viewModel = ViewModelProviders.of(
            this,
            RocketsViewModelFactory()
        ).get(RocketsViewModel::class.java)



        viewModel.show.observe(this, Observer { lce ->
            when (lce) {
                is LCE.Content -> {
                    Log.d("***", "The content ${lce.content}")
                }
                is LCE.Loading -> {
                    Log.d("***", "The loading")
                }
                is LCE.Error -> {
                    Log.d("***", "The error")
                }
            }
        })
    }
}
