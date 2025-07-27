package com.arcus.network.repository

import com.arcus.model.CatFact
import com.arcus.network.ApiCall
import com.arcus.network.NetworkService
import com.arcus.network.api.SplashApi
import kotlinx.coroutines.CoroutineScope

class SplashRepository(
    private val api: SplashApi,
) {
    fun getFacts(scope: CoroutineScope): ApiCall<CatFact> = NetworkService.call(scope) { api.getFacts() }
}
