package com.arcus.core.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

var colors by mutableStateOf(Colors())

@Immutable
@Stable
open class Colors {
    val transparent = Color(0x00000000)
    open val orange1: Color = transparent
    open val orange2: Color = transparent
    open val orange3: Color = transparent
    open val asphalt1: Color = transparent
    open val asphalt2: Color = transparent
    open val asphalt3: Color = transparent
    open val asphalt4: Color = transparent
    open val stone1: Color = transparent
    open val stone2: Color = transparent
    open val stone3: Color = transparent
    open val stone4: Color = transparent
    open val stone5: Color = transparent
    open val grey100: Color = transparent
    open val success: Color = transparent
    open val error: Color = transparent
    open val warning: Color = transparent
    open val info: Color = transparent
    open val white: Color = transparent
    open val whiteSmoke: Color = transparent
    open val desertStorm: Color = transparent
    open val ghostWhite: Color = transparent
    open val hunterGreen: Color = transparent
    open val hint: Color = transparent
    open val borderOrange: Color = transparent
}

class ColorsLight : Colors() {
    override val orange1 = Color(0xFFF68B1F)
    override val orange2 = Color(0xFFFABF83)
    override val orange3 = Color(0xFFFEF2E6)
    override val asphalt1 = Color(0xFF43485D)
    override val asphalt2 = Color(0xFF9799A5)
    override val asphalt3 = Color(0xFFC1C4D3)
    override val asphalt4 = Color(0xFFEAEBED)
    override val stone1 = Color(0xFFBFC6CE)
    override val stone2 = Color(0xFFCED4DA)
    override val stone3 = Color(0xFFDEE2E6)
    override val stone4 = Color(0xFFE9ECEF)
    override val stone5 = Color(0xFFF8F9FA)
    override val grey100 = Color(0xFF000000)
    override val success = Color(0xFF28A745)
    override val error = Color(0xFFDC3545)
    override val warning = Color(0xFFFFD24C)
    override val info = Color(0xFF17A2B8)
    override val white = Color(0xFFFFFFFF)
    override val whiteSmoke = Color(0xFFF3F3F3)
    override val desertStorm = Color(0xFFE4EAEF)
    override val ghostWhite = Color(0xFFF5F6F7)
    override val hunterGreen = Color(0xFF051C7D)
    override val hint = Color(0xFF6A6C75)
    override val borderOrange = Color(0xFFFDEAD8)
}
