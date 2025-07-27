package com.arcus.di

import com.arcus.core.constants.SecureStorage
import com.arcus.core.constants.SessionManager
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val coreModule =
    module {
        single { SecureStorage(androidContext()) }
        single { SessionManager(get()) }
    }
