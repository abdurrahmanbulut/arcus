package com.abdurrahmanbulut.arcus.app

import android.app.Application
import com.abdurrahmanbulut.arcus.core.theme.DrawablesLight
import com.abdurrahmanbulut.arcus.core.theme.drawables
import com.abdurrahmanbulut.arcus.di.apiModule
import com.abdurrahmanbulut.arcus.di.coreModule
import com.abdurrahmanbulut.arcus.di.repositoryModule
import com.abdurrahmanbulut.arcus.di.viewmodelModule
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
