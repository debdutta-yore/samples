package com.yore.samples.core.domain

import com.yore.samples.core.common.Action
import com.yore.samples.core.common.Command
import com.yore.samples.core.common.Page
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SplashUseCase @Inject constructor(
) {
    companion object {
        private const val TAG = "SplashUseCase"
    }
    operator fun invoke(): Flow<Command> = flow {
        emit(Command(Action.LOADING))
        delay(2000)
        emit(Command(Action.LOADING_STOP))
        delay(1000)
        emit(Command(Action.NAVIGATE, Page.HOME))
    }

}
