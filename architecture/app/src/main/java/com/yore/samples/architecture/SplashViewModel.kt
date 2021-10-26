package com.yore.samples.architecture

import androidx.lifecycle.LifecycleObserver
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel
@Inject constructor(private val splashUseCase: SplashUseCase) : ObservableViewModel(),
    LifecycleObserver {

}