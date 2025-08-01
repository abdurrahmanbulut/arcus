package com.abdurrahmanbulut.arcus.di

import com.abdurrahmanbulut.arcus.core.network.api.SplashApi
import com.abdurrahmanbulut.arcus.core.network.provideLoggingInterceptor
import com.abdurrahmanbulut.arcus.core.network.provideOkHttpClient
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val baseUrl = "https://catfact.ninja/"

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
    Retrofit
        .Builder()
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

fun splashApi(retrofit: Retrofit): SplashApi = retrofit.create(SplashApi::class.java)

val apiModule =
    module {
        single { provideLoggingInterceptor() }
        single { provideOkHttpClient(get()) }
        single { provideRetrofit(get()) }
        single { splashApi(get()) }
    }
