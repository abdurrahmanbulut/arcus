package com.arcus.core.constants

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Simple secure storage implementation using Android KeyStore for encryption
 * and SharedPreferences for persistence.
 */
class SecureStorage(
    context: Context,
) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(
            "secure_storage",
            Context.MODE_PRIVATE,
        )

    private val androidKeyStore = AndroidKeyStore()

    /**
     * Store a string value securely
     */
    suspend fun putString(
        key: String,
        value: String,
    ): Boolean =
        withContext(Dispatchers.IO) {
            try {
                val encryptedValue = androidKeyStore.encrypt(value)
                sharedPreferences.edit {
                    putString(key, encryptedValue)
                }
                true
            } catch (e: Exception) {
                e.printStackTrace()
                false
            }
        }

    /**
     * Retrieve a string value securely
     */
    suspend fun getString(
        key: String,
        defaultValue: String = "",
    ): String =
        withContext(Dispatchers.IO) {
            try {
                val encryptedValue = sharedPreferences.getString(key, null)
                if (encryptedValue != null) {
                    androidKeyStore.decrypt(encryptedValue)
                } else {
                    defaultValue
                }
            } catch (e: Exception) {
                e.printStackTrace()
                defaultValue
            }
        }

    /**
     * Store an integer value securely
     */
    suspend fun putInt(
        key: String,
        value: Int,
    ): Boolean =
        withContext(Dispatchers.IO) {
            putString(key, value.toString())
        }

    /**
     * Retrieve an integer value securely
     */
    suspend fun getInt(
        key: String,
        defaultValue: Int = 0,
    ): Int =
        withContext(Dispatchers.IO) {
            try {
                val stringValue = getString(key)
                if (stringValue.isNotEmpty()) {
                    stringValue.toInt()
                } else {
                    defaultValue
                }
            } catch (e: Exception) {
                e.printStackTrace()
                defaultValue
            }
        }

    /**
     * Store a boolean value securely
     */
    suspend fun putBoolean(
        key: String,
        value: Boolean,
    ): Boolean =
        withContext(Dispatchers.IO) {
            putString(key, value.toString())
        }

    /**
     * Retrieve a boolean value securely
     */
    suspend fun getBoolean(
        key: String,
        defaultValue: Boolean = false,
    ): Boolean =
        withContext(Dispatchers.IO) {
            try {
                val stringValue = getString(key)
                if (stringValue.isNotEmpty()) {
                    stringValue.toBoolean()
                } else {
                    defaultValue
                }
            } catch (e: Exception) {
                e.printStackTrace()
                defaultValue
            }
        }

    /**
     * Store a long value securely
     */
    suspend fun putLong(
        key: String,
        value: Long,
    ): Boolean =
        withContext(Dispatchers.IO) {
            putString(key, value.toString())
        }

    /**
     * Retrieve a long value securely
     */
    suspend fun getLong(
        key: String,
        defaultValue: Long = 0L,
    ): Long =
        withContext(Dispatchers.IO) {
            try {
                val stringValue = getString(key)
                if (stringValue.isNotEmpty()) {
                    stringValue.toLong()
                } else {
                    defaultValue
                }
            } catch (e: Exception) {
                e.printStackTrace()
                defaultValue
            }
        }

    /**
     * Check if a key exists
     */
    fun contains(key: String): Boolean = sharedPreferences.contains(key)

    /**
     * Remove a specific key
     */
    fun remove(key: String): Boolean =
        try {
            sharedPreferences.edit {
                remove(key)
            }
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }

    /**
     * Clear all stored data
     */
    fun clear(): Boolean =
        try {
            sharedPreferences.edit {
                clear()
            }
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }

    /**
     * Get all keys
     */
    fun getAllKeys(): Set<String> = sharedPreferences.all.keys
}
