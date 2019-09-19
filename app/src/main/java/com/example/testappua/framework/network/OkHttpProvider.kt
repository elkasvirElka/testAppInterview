package com.example.testappua.framework.network

import com.example.testappua.BuildConfig
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

class OkHttpProvider{
    companion object {
        fun provideClient(): OkHttpClient {
            val builder = OkHttpClient.Builder()
            builder.addInterceptor(ApiKeyInterceptor())
            if (BuildConfig.DEBUG) {
                builder.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                builder.addNetworkInterceptor(StethoInterceptor())
            }

            return builder.build()
        }
    }
}