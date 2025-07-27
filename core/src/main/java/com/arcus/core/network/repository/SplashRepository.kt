package com.arcus.core.network.repository

import com.arcus.core.model.CatFact
import com.arcus.core.network.ApiCall
import com.arcus.core.network.NetworkService
import com.arcus.core.network.api.SplashApi
import kotlinx.coroutines.CoroutineScope

class SplashRepository(
    private val api: SplashApi,
) {
    fun getFacts(scope: CoroutineScope): ApiCall<CatFact> = NetworkService.call(scope) { api.getFacts() }
}
