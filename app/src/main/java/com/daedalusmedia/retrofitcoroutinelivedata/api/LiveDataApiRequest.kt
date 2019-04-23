package com.daedalusmedia.retrofitcoroutinelivedata.api

import androidx.lifecycle.MutableLiveData
import com.google.gson.JsonParser
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Response
import java.net.SocketTimeoutException

private const val NO_NETWORK_RESPONSE = 600
private const val NO_NETWORK_MESSAGE = "No network response"

class LiveDataApiRequest<T>(
    private val jobs: MutableList<Job>,
    private val jobError: MutableLiveData<SpaceXError>,
    private var requiredTask: Deferred<Response<T>>
) : MutableLiveData<T>() {

    override fun onActive() {
        if (value == null) {
            makeServiceRequest(requiredTask, success(), error(), jobs)
        }
    }

    private fun error(): (SpaceXError) -> Unit = {
        jobError.value = it
    }

    private fun success(): (T?) -> Unit = {
        value = it
    }

    private fun <T> makeServiceRequest(
        task: Deferred<Response<T>>?,
        complete: (value: T?) -> Unit,
        error: (e: SpaceXError) -> Unit,
        jobs: MutableList<Job>
    ) {
        val job: Job = GlobalScope.launch(Dispatchers.Main) {
            try {
                val response = task?.await()
                response?.let {
                    if (response.isSuccessful) {
                        complete.invoke(it.body())
                    } else {
                        val errorMessage = JsonParser().parse(it.errorBody()?.string()).asJsonObject.get("error").asString
                        error.invoke(SpaceXError(it.code(), errorMessage))
                    }
                }
            } catch (e: SocketTimeoutException) {
                error.invoke(SpaceXError(NO_NETWORK_RESPONSE, NO_NETWORK_MESSAGE))
            }
        }
        jobs.add(job)
        job.invokeOnCompletion { jobs.remove(job) }
    }
}
