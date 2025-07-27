package com.arcus.features.main

import androidx.lifecycle.ViewModel
import com.arcus.app.navigation.screen.Screen
import com.arcus.core.navigation.Navigator

class MainScreenVM : ViewModel() {
    lateinit var navigator: Navigator

    fun onClickHome() {
        navigator.popAllAndNavigate(Screen.Main.Home.route)
    }

    fun onClickSearch() {
        navigator.popAllAndNavigate(Screen.Main.Search.route)
    }

    fun onClickProfile() {
        navigator.popAllAndNavigate(Screen.Main.Profile.route)
    }

    fun onClickSettings() {
        navigator.popAllAndNavigate(Screen.Main.Settings.route)
    }
}
