package com.yore.samples.architecture

class Events<out T>(private val content: T) {
    private var hasBeenHandled = false

    fun getContentIfNotHandled() = if (!hasBeenHandled) {
        hasBeenHandled = true
        content
    } else
        null

    fun peekContent(): T = content
}