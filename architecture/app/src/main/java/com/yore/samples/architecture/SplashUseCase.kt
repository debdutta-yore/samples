package com.yore.samples.architecture

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
        delay(300)
        emit(Command(Action.NAVIGATE, Page.HOME))
    }

}
