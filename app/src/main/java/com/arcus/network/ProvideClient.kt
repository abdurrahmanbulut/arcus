package com.arcus.network

import okhttp3.OkHttpClient

fun provideLoggingInterceptor(): CustomHttpLoggingInterceptor = CustomHttpLoggingInterceptor()

fun provideOkHttpClient(loggingInterceptor: CustomHttpLoggingInterceptor): OkHttpClient =
    OkHttpClient
        .Builder()
        .addInterceptor(loggingInterceptor)
        .build()
