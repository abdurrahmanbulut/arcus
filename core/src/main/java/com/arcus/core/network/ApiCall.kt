package com.arcus.core.network

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class ApiCall<T> {
    private var onSuccess: ((T) -> Unit)? = null
    private var onFailure: ((Throwable) -> Unit)? = null
    private var onLoading: ((Boolean) -> Unit)? = null

    fun success(callback: (T) -> Unit): ApiCall<T> {
        onSuccess = callback
        return this
    }

    fun failure(callback: (Throwable) -> Unit): ApiCall<T> {
        onFailure = callback
        return this
    }

    fun loading(callback: (Boolean) -> Unit): ApiCall<T> {
        onLoading = callback
        return this
    }

    internal fun execute(
        scope: CoroutineScope,
        apiCall: suspend () -> T,
    ) {
        onLoading?.invoke(true)
        scope.launch {
            try {
                val result = apiCall()
                onLoading?.invoke(false)
                onSuccess?.invoke(result)
            } catch (e: Exception) {
                onLoading?.invoke(false)
                onFailure?.invoke(e)
            }
        }
    }
}
