package com.abdurrahmanbulut.arcus.di

import com.abdurrahmanbulut.arcus.core.constants.InsetsViewModel
import com.abdurrahmanbulut.arcus.features.main.MainScreenVM
import com.abdurrahmanbulut.arcus.features.main.home.HomeScreenVM
import com.abdurrahmanbulut.arcus.features.main.settings.InboxScreenVM
import com.abdurrahmanbulut.arcus.features.search.SearchScreenVM
import com.abdurrahmanbulut.arcus.features.splash.SplashViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val viewmodelModule =
    module {
        viewModelOf(::SplashViewModel)
        viewModelOf(::HomeScreenVM)
        viewModelOf(::MainScreenVM)
        viewModelOf(::InsetsViewModel)
        viewModelOf(::SearchScreenVM)
        viewModelOf(::InboxScreenVM)
    }
