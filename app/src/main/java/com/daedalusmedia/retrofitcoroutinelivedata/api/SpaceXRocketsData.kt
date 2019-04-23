package com.daedalusmedia.retrofitcoroutinelivedata.api

data class SpaceXRocketsData(
    val description: String,
    val rocketName: String,
    val firstFlight: String,
    val height: Height
)

data class Height(
    val feet: Double,
    val meters: Double
)
