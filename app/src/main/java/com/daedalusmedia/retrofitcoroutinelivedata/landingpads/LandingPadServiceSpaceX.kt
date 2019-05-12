package com.daedalusmedia.retrofitcoroutinelivedata.landingpads

import androidx.lifecycle.MutableLiveData
import com.daedalusmedia.retrofitcoroutinelivedata.api.DeferredManager
import com.daedalusmedia.retrofitcoroutinelivedata.api.LiveDataApiRequest
import com.daedalusmedia.retrofitcoroutinelivedata.api.SpaceXApi
import com.daedalusmedia.retrofitcoroutinelivedata.api.SpaceXLandingPadsData

class LandingPadServiceSpaceX(private val api: SpaceXApi) : LandingPadService, DeferredManager() {
    override fun getLandingPads(): MutableLiveData<List<SpaceXLandingPadsData>> = LiveDataApiRequest(jobs, jobError, api.landPadsAsync())
}
