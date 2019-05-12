package com.daedalusmedia.retrofitcoroutinelivedata.landingpads

import androidx.lifecycle.ViewModel

class LandingPadViewModel(private val landingPadService: LandingPadService) : ViewModel() {
    val show = LandingPadLceCreator(
        landingPadService.getLandingPads(),
        landingPadService.getOnError()
    )

    override fun onCleared() {
        landingPadService.clear()
    }
}
