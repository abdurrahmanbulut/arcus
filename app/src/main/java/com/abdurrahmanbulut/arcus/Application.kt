package com.abdurrahmanbulut.arcus

import android.app.Application
import com.abdurrahmanbulut.arcus.constants.DataStoreHelper
import com.abdurrahmanbulut.arcus.constants.getInitialLocalizationStrings
import com.abdurrahmanbulut.arcus.constants.localizationStrings
import com.abdurrahmanbulut.arcus.di.apiModule
import com.abdurrahmanbulut.arcus.di.repositoryModule
import com.abdurrahmanbulut.arcus.di.viewmodelModule
import com.abdurrahmanbulut.arcus.ui.theme.DrawablesLight
import com.abdurrahmanbulut.arcus.ui.theme.drawables
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class Application : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            val modules = listOf(repositoryModule, viewmodelModule, apiModule)
            androidLogger()
            androidContext(this@Application)
            koin.loadModules(modules)
        }

        val dataStoreHelper: DataStoreHelper by inject<DataStoreHelper>()
        drawables = DrawablesLight()
        MainScope().launch {
            localizationStrings = getInitialLocalizationStrings(dataStoreHelper = dataStoreHelper)
        }
    }
}
