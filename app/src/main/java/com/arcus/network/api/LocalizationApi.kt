package com.arcus.network.api

import com.arcus.constants.LocalizationKeys
import retrofit2.http.GET
import retrofit2.http.Query

interface LocalizationApi {
    @GET("localization")
    suspend fun getLocalizationStrings(
        @Query("lang") lang: String,
    ): List<LocalizationKeys>
}
