package com.abdurrahmanbulut.arcus.ui.splash

import androidx.lifecycle.ViewModel
import com.abdurrahmanbulut.arcus.network.repository.SplashRepository
import org.koin.core.component.KoinComponent

class SplashViewModel(private val repository: SplashRepository) : ViewModel(), KoinComponent
