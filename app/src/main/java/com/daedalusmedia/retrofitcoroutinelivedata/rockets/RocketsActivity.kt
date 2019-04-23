package com.daedalusmedia.retrofitcoroutinelivedata.rockets

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.daedalusmedia.retrofitcoroutinelivedata.R

class RocketsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rockets)

        val viewModel = ViewModelProviders.of(
            this,
            RocketsViewModelFactory()
        ).get(RocketsViewModel::class.java)

        viewModel.rockets.observe(this, Observer { rockets ->

            rockets.forEach {
                Log.d("***", "ROCKET ${it.rocketName}")
            }
        })
    }
}
