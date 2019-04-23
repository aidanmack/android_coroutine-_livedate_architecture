package com.daedalusmedia.retrofitcoroutinelivedata.rockets

import androidx.lifecycle.ViewModel

class RocketsViewModel(private val rocketsService: RocketsService) : ViewModel() {
    val rockets = rocketsService.getRockets()
    override fun onCleared() {
        rocketsService.clear()
    }
}
