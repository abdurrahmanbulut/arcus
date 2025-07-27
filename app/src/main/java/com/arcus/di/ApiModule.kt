package com.arcus.di

import com.arcus.network.api.SplashApi
import com.arcus.network.provideLoggingInterceptor
import com.arcus.network.provideOkHttpClient
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
