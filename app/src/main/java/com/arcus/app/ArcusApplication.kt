package com.arcus.app

import android.app.Application
import com.arcus.constants.DataStoreHelper
import com.arcus.constants.getInitialLocalizationStrings
import com.arcus.constants.localizationStrings
import com.arcus.core.ui.theme.DrawablesLight
import com.arcus.core.ui.theme.drawables
import com.arcus.di.apiModule
import com.arcus.di.repositoryModule
import com.arcus.di.viewmodelModule
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class ArcusApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            val modules = listOf(repositoryModule, viewmodelModule, apiModule)
            androidLogger()
            androidContext(this@ArcusApplication)
            koin.loadModules(modules)
        }

        val dataStoreHelper: DataStoreHelper by inject<DataStoreHelper>()
        drawables = DrawablesLight()
        MainScope().launch {
            localizationStrings = getInitialLocalizationStrings(dataStoreHelper = dataStoreHelper)
        }
    }
}
