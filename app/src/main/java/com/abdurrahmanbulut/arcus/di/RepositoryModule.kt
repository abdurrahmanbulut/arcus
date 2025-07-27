package com.abdurrahmanbulut.arcus.di

import com.abdurrahmanbulut.arcus.core.network.repository.SplashRepository
import com.abdurrahmanbulut.arcus.core.network.repository.StockRepository
import org.koin.dsl.module

val repositoryModule =
    module {
        single { SplashRepository(get()) }
        single { StockRepository(get()) }
    }
