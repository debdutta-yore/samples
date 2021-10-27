package com.yore.samples.core

data class Command(
    val action: Action,
    val target: Any? = null
)