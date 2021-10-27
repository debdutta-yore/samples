package com.yore.samples.architecture

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.yore.samples.core.Action
import com.yore.samples.core.Events
import com.yore.samples.core.Page
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SplashViewModel
@Inject constructor(private val splashUseCase: SplashUseCase) : ObservableViewModel(),
    LifecycleObserver {
    private val _statusText = MutableLiveData("")
    val statusText
        get() = _statusText

    private val _notifyNavigation = MutableLiveData<Events<Page>>()
        val notifyNavigation
            get() = _notifyNavigation

    init {
        splashUseCase().onEach {
            when(it.action){
                Action.LOADING->{
                    _statusText.value = "Loading..."
                }
                Action.LOADING_STOP->{
                    _statusText.value = "Opening your page"
                }
                Action.NAVIGATE->{
                    notifyNavigation.value = Events(Page.HOME)
                }
            }
        }.launchIn(viewModelScope)
    }
}