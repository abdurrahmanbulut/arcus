package com.arcus.network.repository

import com.arcus.constants.LocalizationKeys
import com.arcus.network.api.LocalizationApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocalizationRepository(
    private val api: LocalizationApi,
) {
    suspend fun fetchLocalizationStrings(lang: String): List<LocalizationKeys> =
        withContext(Dispatchers.IO) {
            api.getLocalizationStrings(lang)
        }
}
