package com.arcus.network

import kotlinx.coroutines.CoroutineScope

object NetworkService {
    fun <T> call(
        scope: CoroutineScope,
        apiCall: suspend () -> T,
    ): ApiCall<T> =
        ApiCall<T>().apply {
            execute(scope, apiCall)
        }
}
