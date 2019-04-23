package com.daedalusmedia.retrofitcoroutinelivedata.api

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Job

abstract class DeferredManager {
    val jobs: MutableList<Job> = mutableListOf()
    val jobError: MutableLiveData<SpaceXError> = MutableLiveData()
    fun clear() {
        jobs.forEach {
            try {
                it.cancel()
            } catch (e: Throwable) {
                // Task already cancelled.
            }
        }
        jobs.clear()
    }

    fun getOnError() = jobError
}
