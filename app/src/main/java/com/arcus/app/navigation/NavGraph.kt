package com.arcus.app.navigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.arcus.app.navigation.screen.Screen
import com.arcus.core.navigation.EnterTransitionCallback
import com.arcus.core.navigation.ExitTransitionCallback
import com.arcus.core.navigation.Navigation
import com.arcus.features.main.MainScreen
import com.arcus.features.splash.SplashScreen

fun NavGraphBuilder.navGraph() {
    screen(Screen.Splash.route) { SplashScreen() }
    screen(Screen.Main.route) { MainScreen() }
}

fun NavGraphBuilder.screen(
    route: String,
    enterTransition: EnterTransitionCallback? = Navigation.enterTransition,
    exitTransition: ExitTransitionCallback? = Navigation.exitTransition,
    popEnterTransition: EnterTransitionCallback? = Navigation.popEnterTransition,
    popExitTransition: ExitTransitionCallback? = Navigation.popExitTransition,
    content: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit,
) {
    composable(
        route = "$route?navArg={navArg}",
        arguments = listOf(navArgument("navArg") { nullable = true }),
        enterTransition = enterTransition,
        exitTransition = exitTransition,
        popEnterTransition = popEnterTransition,
        popExitTransition = popExitTransition,
        content = content,
    )
}
