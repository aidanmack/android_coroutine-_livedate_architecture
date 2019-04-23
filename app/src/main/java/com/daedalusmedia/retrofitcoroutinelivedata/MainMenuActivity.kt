package com.daedalusmedia.retrofitcoroutinelivedata

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.daedalusmedia.retrofitcoroutinelivedata.rockets.RocketsActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainMenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        main_menu_rockets.setOnClickListener {
            startActivity(Intent(this, RocketsActivity::class.java))
        }
    }
}


