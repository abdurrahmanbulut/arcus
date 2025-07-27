package com.arcus.di

import com.arcus.core.network.repository.SplashRepository
import com.arcus.core.network.repository.StockRepository
import org.koin.dsl.module

val repositoryModule =
    module {
        single { SplashRepository(get()) }
        single { StockRepository(get()) }
    }
