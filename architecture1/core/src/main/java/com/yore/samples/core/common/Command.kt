package com.yore.samples.core.common

data class Command(
    val action: Action,
    val target: Any? = null
)