package com.arcus.core.ui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

var drawables by mutableStateOf(Drawables())

open class Drawables {
    open val example: Int = 0
}

class DrawablesLight : Drawables() {
    override val example: Int = 0
}
