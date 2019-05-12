package com.daedalusmedia.retrofitcoroutinelivedata.landingpads

import androidx.lifecycle.MutableLiveData
import com.daedalusmedia.retrofitcoroutinelivedata.api.DeferredManagerInterface
import com.daedalusmedia.retrofitcoroutinelivedata.api.SpaceXLandingPadsData

interface LandingPadService : DeferredManagerInterface {
    fun getLandingPads(): MutableLiveData<List<SpaceXLandingPadsData>>
}
