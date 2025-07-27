package com.abdurrahmanbulut.arcus.core

import com.google.gson.GsonBuilder

class Mapper {
    private val gson = GsonBuilder().create()

    fun <T> toObject(
        json: String?,
        classOfT: Class<T>,
    ): T? {
        try {
            return gson.fromJson(json, classOfT)
        } catch (e: Exception) {
            return null
        }
    }

    fun toJson(value: Any?): String? =
        try {
            gson.toJson(value)
        } catch (e: Exception) {
            null
        }
}
