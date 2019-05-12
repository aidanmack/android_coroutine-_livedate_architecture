package com.daedalusmedia.retrofitcoroutinelivedata.landingpads

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.daedalusmedia.retrofitcoroutinelivedata.api.LCE
import com.daedalusmedia.retrofitcoroutinelivedata.api.SpaceXError
import com.daedalusmedia.retrofitcoroutinelivedata.api.SpaceXLandingPadsData

class LandingPadLceCreator(
    landingPads: MutableLiveData<List<SpaceXLandingPadsData>>,
    onError: MutableLiveData<SpaceXError>
) : MediatorLiveData<LCE<List<SpaceXLandingPadsData>>>() {
    init {
        value = LCE.Loading()

        addSource(landingPads) {
            value = LCE.Content(it)
        }

        addSource(onError) {
            value = LCE.Error(it.message)
        }
    }
}
