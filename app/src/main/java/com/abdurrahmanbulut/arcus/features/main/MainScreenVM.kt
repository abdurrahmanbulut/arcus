package com.abdurrahmanbulut.arcus.features.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.abdurrahmanbulut.arcus.app.navigation.screen.Screen
import com.abdurrahmanbulut.arcus.core.navigation.Navigator

class MainScreenVM : ViewModel() {
    lateinit var navigator: Navigator
    val title = "Fısıltı"
    var activeItem by mutableIntStateOf(0)

    fun onClickHome() {
        activeItem = 0
        navigator.popAllAndNavigate(Screen.Main.Home.route)
    }

    fun onClickInbox() {
        activeItem = 1
        navigator.popAllAndNavigate(Screen.Main.Inbox.route)
    }

    fun onClickSearch() {
        activeItem = 2
        navigator.popAllAndNavigate(Screen.Main.Search.route)
    }

    fun onClickProfile() {
        activeItem = 3
        navigator.popAllAndNavigate(Screen.Main.Profile.route)
    }
}
