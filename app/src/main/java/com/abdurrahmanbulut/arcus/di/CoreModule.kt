package com.abdurrahmanbulut.arcus.di

import com.abdurrahmanbulut.arcus.core.constants.SecureStorage
import com.abdurrahmanbulut.arcus.core.constants.SessionManager
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val coreModule =
    module {
        single { SecureStorage(androidContext()) }
        single { SessionManager(get()) }
    }
