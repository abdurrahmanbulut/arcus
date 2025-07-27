package com.abdurrahmanbulut.arcus.network.repository

import com.abdurrahmanbulut.arcus.constants.LocalizationKeys
import com.abdurrahmanbulut.arcus.network.api.LocalizationApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocalizationRepository(private val api: LocalizationApi) {
    suspend fun fetchLocalizationStrings(lang: String): List<LocalizationKeys> {
        return withContext(Dispatchers.IO) {
            api.getLocalizationStrings(lang)
        }
    }
}
