package com.arcus.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModule {
    private val loggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    private val okHttpClient =
        OkHttpClient
            .Builder()
            .addInterceptor(loggingInterceptor)
            .build()

    fun createRetrofit(baseUrl: String): Retrofit =
        Retrofit
            .Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    inline fun <reified T> createApi(baseUrl: String): T = createRetrofit(baseUrl).create(T::class.java)
}
