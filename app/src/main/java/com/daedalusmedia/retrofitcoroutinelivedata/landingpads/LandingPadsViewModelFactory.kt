package com.daedalusmedia.retrofitcoroutinelivedata.landingpads

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.daedalusmedia.retrofitcoroutinelivedata.api.api

class LandingPadsViewModelFactory : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LandingPadViewModel(LandingPadServiceSpaceX(api)) as T
    }
}
