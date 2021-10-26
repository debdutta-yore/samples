package com.yore.samples.architecture

data class Command(
    val action: Action,
    val target: Any? = null
)