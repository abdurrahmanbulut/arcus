package com.abdurrahmanbulut.arcus.navigator

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.abdurrahmanbulut.arcus.navigator.screen.Screen
import com.abdurrahmanbulut.arcus.ui.main.MainScreen
import com.abdurrahmanbulut.arcus.ui.splash.SplashScreen
import com.abdurrahmanbulut.sherlock.navigation.EnterTransitionCallback
import com.abdurrahmanbulut.sherlock.navigation.ExitTransitionCallback
import com.abdurrahmanbulut.sherlock.navigation.Navigation

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
