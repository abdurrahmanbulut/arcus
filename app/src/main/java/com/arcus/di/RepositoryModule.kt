package com.arcus.di

import com.arcus.constants.DataStoreHelper
import com.arcus.network.repository.SplashRepository
import com.arcus.network.repository.StockRepository
import org.koin.dsl.module

val repositoryModule =
    module {
        single { SplashRepository(get()) }
        single { DataStoreHelper(get()) }
        single { StockRepository(get()) }
    }
