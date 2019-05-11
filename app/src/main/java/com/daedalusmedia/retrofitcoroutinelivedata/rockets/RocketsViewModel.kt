package com.daedalusmedia.retrofitcoroutinelivedata.rockets

import androidx.lifecycle.ViewModel

class RocketsViewModel(private val rocketsService: RocketsService) : ViewModel() {
    val show = RocketsLceCreator(
        rocketsService.getRockets(),
        rocketsService.getOnError()
    )

    override fun onCleared() {
        rocketsService.clear()
    }
}
