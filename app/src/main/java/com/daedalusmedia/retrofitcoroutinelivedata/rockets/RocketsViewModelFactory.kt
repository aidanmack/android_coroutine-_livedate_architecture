package com.daedalusmedia.retrofitcoroutinelivedata.rockets

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.daedalusmedia.retrofitcoroutinelivedata.api.api

class RocketsViewModelFactory : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return RocketsViewModel(RocketsServiceSpaceX(api)) as T
    }
}
