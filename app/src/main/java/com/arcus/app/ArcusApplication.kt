package com.arcus.app

import android.app.Application
import com.arcus.core.theme.DrawablesLight
import com.arcus.core.theme.drawables
import com.arcus.di.apiModule
import com.arcus.di.coreModule
import com.arcus.di.repositoryModule
import com.arcus.di.viewmodelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class ArcusApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            val modules = listOf(repositoryModule, viewmodelModule, apiModule, coreModule)
            androidLogger()
            androidContext(this@ArcusApplication)
            koin.loadModules(modules)
        }

        drawables = DrawablesLight()
    }
}
