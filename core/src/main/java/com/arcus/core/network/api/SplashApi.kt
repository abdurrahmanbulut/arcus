package com.arcus.core.network.api

import com.arcus.core.model.Breeds
import com.arcus.core.model.CatFact
import retrofit2.http.GET

interface SplashApi {
    @GET("fact")
    suspend fun getFacts(): CatFact

    @GET("breeds")
    suspend fun getBreeds(): Breeds
}
