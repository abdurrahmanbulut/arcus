package com.abdurrahmanbulut.arcus.network.api

import com.abdurrahmanbulut.arcus.model.Breeds
import com.abdurrahmanbulut.arcus.model.CatFact
import retrofit2.http.GET

interface SplashApi {
    @GET("fact")
    suspend fun getFacts(): CatFact

    @GET("breeds")
    suspend fun getBreeds(): Breeds
}
