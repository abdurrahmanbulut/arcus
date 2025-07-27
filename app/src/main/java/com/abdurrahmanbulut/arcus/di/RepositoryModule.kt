package com.abdurrahmanbulut.arcus.di

import com.abdurrahmanbulut.arcus.constants.DataStoreHelper
import com.abdurrahmanbulut.arcus.network.repository.SplashRepository
import com.abdurrahmanbulut.arcus.network.repository.StockRepository
import org.koin.dsl.module

val repositoryModule =
    module {
        single { SplashRepository(get()) }
        single { DataStoreHelper(get()) }
        single { StockRepository(get()) }
    }
