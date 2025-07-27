package com.abdurrahmanbulut.arcus.core.network.api

import com.abdurrahmanbulut.arcus.core.model.Breeds
import com.abdurrahmanbulut.arcus.core.model.CatFact
import retrofit2.http.GET

interface SplashApi {
    @GET("fact")
    suspend fun getFacts(): CatFact

    @GET("breeds")
    suspend fun getBreeds(): Breeds
}
