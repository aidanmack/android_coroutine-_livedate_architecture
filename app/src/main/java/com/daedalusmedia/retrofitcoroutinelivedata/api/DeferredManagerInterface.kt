package com.daedalusmedia.retrofitcoroutinelivedata.api

import androidx.lifecycle.MutableLiveData

interface DeferredManagerInterface {
    fun clear()
    fun getOnError(): MutableLiveData<SpaceXError>
}
