package com.abdurrahmanbulut.arcus.di

import com.abdurrahmanbulut.arcus.ui.InsetsViewModel
import com.abdurrahmanbulut.arcus.ui.main.MainScreenVM
import com.abdurrahmanbulut.arcus.ui.main.home.HomeScreenVM
import com.abdurrahmanbulut.arcus.ui.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewmodelModule =
    module {
        viewModel { SplashViewModel(get()) }
        viewModel { HomeScreenVM(get()) }
        viewModel { MainScreenVM() }
        viewModel { InsetsViewModel() }
    }
