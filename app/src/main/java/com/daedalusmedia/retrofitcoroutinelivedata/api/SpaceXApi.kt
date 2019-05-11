package com.daedalusmedia.retrofitcoroutinelivedata.api

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

val api get() = SpaceXApi.instance()

interface SpaceXApi {

    @GET("rockets")
    fun rocketsAsync(): Deferred<Response<List<SpaceXRocketsData>>>

    companion object Factory {
        private var retrofit: Retrofit = buildRetrofit()
        private const val BASE_URL: String = "https://api.spacexdata.com/v3/"
        fun instance(): SpaceXApi {
            return retrofit.create(SpaceXApi::class.java)
        }

        private fun buildRetrofit() = retrofit2.Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create(setGsonRules()))
            .build()

        private fun setGsonRules(): Gson =
            GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create()
    }
}
