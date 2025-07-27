package com.arcus.di

import com.arcus.features.InsetsViewModel
import com.arcus.features.main.MainScreenVM
import com.arcus.features.main.home.HomeScreenVM
import com.arcus.features.main.settings.SettingsScreenVM
import com.arcus.features.search.SearchScreenVM
import com.arcus.features.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewmodelModule =
    module {
        viewModel { SplashViewModel(get()) }
        viewModel { HomeScreenVM(get()) }
        viewModel { MainScreenVM() }
        viewModel { InsetsViewModel() }
        viewModel { SearchScreenVM() }
        viewModel { SettingsScreenVM() }
    }
