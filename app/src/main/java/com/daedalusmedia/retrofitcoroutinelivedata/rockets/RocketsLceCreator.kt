package com.daedalusmedia.retrofitcoroutinelivedata.rockets

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.daedalusmedia.retrofitcoroutinelivedata.api.LCE
import com.daedalusmedia.retrofitcoroutinelivedata.api.SpaceXError
import com.daedalusmedia.retrofitcoroutinelivedata.api.SpaceXRocketsData

class RocketsLceCreator(
    rockets: LiveData<List<SpaceXRocketsData>>,
    error: LiveData<SpaceXError>
) : MediatorLiveData<LCE<List<SpaceXRocketsData>>>() {
    init {
        value = LCE.Loading()
        addSource(rockets) {
            value = LCE.Content(it)
        }
        addSource(error) {
            value = LCE.Error(it.message)
        }
    }
}
