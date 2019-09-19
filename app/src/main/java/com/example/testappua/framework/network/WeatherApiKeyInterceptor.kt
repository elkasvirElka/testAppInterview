package com.example.testappua.framework.network

import com.example.testappua.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val originalHttpUrl = original.url()
        val url = originalHttpUrl.newBuilder()
            .addQueryParameter("apiKey", BuildConfig.API_KEY)
            .build()

        return chain.proceed(original.newBuilder().url(url).build())
    }

}