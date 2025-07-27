package com.abdurrahmanbulut.arcus.network.repository

import com.abdurrahmanbulut.arcus.model.CatFact
import com.abdurrahmanbulut.arcus.network.api.SplashApi
import com.abdurrahmanbulut.sherlock.network.CallHandler
import com.abdurrahmanbulut.sherlock.network.Service.call
import kotlinx.coroutines.CoroutineScope

class SplashRepository(private val api: SplashApi) {
    fun getFacts(coroutineScope: CoroutineScope): CallHandler<CatFact> {
        return coroutineScope.call(
            repositoryCall = {
                api.getFacts()
            },
        )
    }
}
