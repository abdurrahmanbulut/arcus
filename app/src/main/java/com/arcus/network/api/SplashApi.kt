package com.arcus.network.api

import com.arcus.model.Breeds
import com.arcus.model.CatFact
import retrofit2.http.GET

interface SplashApi {
    @GET("fact")
    suspend fun getFacts(): CatFact

    @GET("breeds")
    suspend fun getBreeds(): Breeds
}
