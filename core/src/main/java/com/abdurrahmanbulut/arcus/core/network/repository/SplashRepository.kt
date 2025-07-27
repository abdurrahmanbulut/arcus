package com.abdurrahmanbulut.arcus.core.network.repository

import com.abdurrahmanbulut.arcus.core.model.CatFact
import com.abdurrahmanbulut.arcus.core.network.ApiCall
import com.abdurrahmanbulut.arcus.core.network.NetworkService
import com.abdurrahmanbulut.arcus.core.network.api.SplashApi
import kotlinx.coroutines.CoroutineScope

class SplashRepository(
    private val api: SplashApi,
) {
    fun getFacts(scope: CoroutineScope): ApiCall<CatFact> = NetworkService.call(scope) { api.getFacts() }
}
