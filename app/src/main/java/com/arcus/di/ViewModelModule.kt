package com.arcus.di

import com.arcus.core.constants.InsetsViewModel
import com.arcus.features.main.MainScreenVM
import com.arcus.features.main.home.HomeScreenVM
import com.arcus.features.main.settings.InboxScreenVM
import com.arcus.features.search.SearchScreenVM
import com.arcus.features.splash.SplashViewModel
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
