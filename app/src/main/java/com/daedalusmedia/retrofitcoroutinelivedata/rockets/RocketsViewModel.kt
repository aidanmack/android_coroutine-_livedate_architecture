package com.daedalusmedia.retrofitcoroutinelivedata.rockets

import androidx.lifecycle.ViewModel

class RocketsViewModel(private val rocketsService: RocketsService) : ViewModel() {
    val rockets = rocketsService.getRockets()

    val show = RocketsLceCreator(rockets, rocketsService.getOnError())

    override fun onCleared() {
        rocketsService.clear()
    }
}
