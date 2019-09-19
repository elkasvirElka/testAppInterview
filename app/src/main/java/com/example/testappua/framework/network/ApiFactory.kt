package com.example.testappua.framework.network

import com.example.testappua.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiFactory {
    companion object {
        private lateinit var sRetrofit: Retrofit

        lateinit var httpClient: OkHttpClient

        fun getRetrofitInstance(): Retrofit {
            if (sRetrofit == null) {
                sRetrofit = Retrofit.Builder()
                    .baseUrl(BuildConfig.API_BASE_URL)
                    .client(provideClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
            }
            return sRetrofit
        }

        private fun provideClient(): OkHttpClient {
            if (httpClient == null) {
                httpClient = OkHttpProvider.provideClient()
            }
            return httpClient
        }
    }
}