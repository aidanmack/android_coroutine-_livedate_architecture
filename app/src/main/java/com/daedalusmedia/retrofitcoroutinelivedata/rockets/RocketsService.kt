package com.daedalusmedia.retrofitcoroutinelivedata.rockets

import androidx.lifecycle.MutableLiveData
import com.daedalusmedia.retrofitcoroutinelivedata.api.DeferredManagerInterface
import com.daedalusmedia.retrofitcoroutinelivedata.api.SpaceXRocketsData

interface RocketsService : DeferredManagerInterface {
    fun getRockets(): MutableLiveData<List<SpaceXRocketsData>>
}
