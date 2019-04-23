package com.daedalusmedia.retrofitcoroutinelivedata.rockets

import androidx.lifecycle.MutableLiveData
import com.daedalusmedia.retrofitcoroutinelivedata.api.DeferredManager
import com.daedalusmedia.retrofitcoroutinelivedata.api.LiveDataApiRequest
import com.daedalusmedia.retrofitcoroutinelivedata.api.SpaceXRocketsData
import com.daedalusmedia.retrofitcoroutinelivedata.api.SpaceXApi

class RocketsServiceSpaceX(private val api: SpaceXApi) : RocketsService, DeferredManager() {
    override fun getRockets(): MutableLiveData<List<SpaceXRocketsData>> = LiveDataApiRequest(jobs, jobError, api.therockAsync())
}
