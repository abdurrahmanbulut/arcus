package com.arcus.core.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.navigation.NavBackStackEntry

data object Navigation {
    var enterTransition: EnterTransitionCallback =
        { slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Left, tween(300)) }
    var exitTransition: ExitTransitionCallback =
        { slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Left, tween(300)) }
    var popEnterTransition: EnterTransitionCallback =
        { slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Right, tween(300)) }
    var popExitTransition: ExitTransitionCallback =
        { slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Right, tween(300)) }
}

typealias EnterTransitionCallback = AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition
typealias ExitTransitionCallback = AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition
