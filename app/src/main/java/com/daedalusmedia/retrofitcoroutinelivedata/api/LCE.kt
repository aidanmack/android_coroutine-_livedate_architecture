package com.daedalusmedia.retrofitcoroutinelivedata.api

sealed class LCE<T> {
    data class Loading<T>(val content: T? = null) : LCE<T>()
    data class Content<T>(val content: T) : LCE<T>()
    data class Error<T>(val error: String) : LCE<T>()
}
