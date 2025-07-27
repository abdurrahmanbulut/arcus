package com.arcus.core.constants

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class SessionManager(
    private val storage: SecureStorage,
) {
    private var sessionData: SessionData? = null

    fun startSession(scope: CoroutineScope) {
        scope.launch {
            sessionData =
                SessionData(
                    token = storage.getString(StorageKeys.TOKEN),
                    userId = storage.getString(StorageKeys.USER_ID),
                )
        }
    }

    fun getSession(): SessionData? = sessionData

    fun isLoggedIn(): Boolean = !sessionData?.token.isNullOrEmpty()

    fun saveSession(
        token: String,
        userId: String,
        email: String,
        scope: CoroutineScope,
    ) {
        scope.launch {
            storage.putString(StorageKeys.TOKEN, token)
            storage.putString(StorageKeys.USER_ID, userId)
        }

        startSession(scope) // güncel verileri yükle
    }

    fun clearSession(scope: CoroutineScope) {
        scope.launch {
            storage.putString(StorageKeys.TOKEN, "")
            storage.putString(StorageKeys.USER_ID, "")
        }
        sessionData = null
    }
}

data class SessionData(
    val token: String?,
    val userId: String?,
)
