package com.arcus.core.navigation

import android.util.Base64
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.arcus.core.Mapper

open class Navigator(
    private val navController: NavHostController,
) {
    fun navigate(
        route: String,
        arg: Any? = null,
    ) {
        val encodedArg = if (arg == null) null else encodeArguments(arg)
        navController.navigate("$route?navArg=$encodedArg")
    }

    fun pop() {
        navController.popBackStack()
    }

    fun popAllAndNavigate(
        route: String,
        arg: Any? = null,
    ) {
        val encodedArg = if (arg == null) null else encodeArguments(arg)
        navController.navigate("$route?navArg=$encodedArg") {
            popUpTo(navController.graph.id) {
                inclusive = true
            }
            launchSingleTop = true
        }
    }
}

fun <T> encodeArguments(arg: T): String {
    val mapper = Mapper()
    val json = mapper.toJson(arg)
    return Base64.encodeToString(json?.toByteArray(), Base64.NO_WRAP)
}

inline fun <reified T> NavBackStackEntry.toNavArg(): T? {
    val arg = arguments?.getString("navArg") ?: return null
    val decodedArg = String(Base64.decode(arg, Base64.DEFAULT))
    return Mapper().toObject(decodedArg, T::class.java)
}
