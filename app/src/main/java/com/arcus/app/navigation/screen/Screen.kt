package com.arcus.app.navigation.screen

sealed class Screen(
    val route: String,
) {
    data object Splash : Screen("splash")

    data object Main : Screen("main") {
        data object Home : Screen("mainHome")

        data object Profile : Screen("profile")

        data object Inbox : Screen("inbox")

        data object Search : Screen("search")
    }
}
