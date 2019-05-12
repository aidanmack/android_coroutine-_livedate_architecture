package com.daedalusmedia.retrofitcoroutinelivedata.api

data class SpaceXLandingPadsData(val fullName: String, val status: String, val location: Location)
data class Location(val name: String)

