package com.example.testappua.di.module

import com.example.testappua.framework.network.OkHttpProvider
import com.example.testappua.framework.network.RxNewsClient
import com.example.testappua.framework.network.source.BuildConfig
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class FrameworkModule {

    @Singleton
    @Provides
    fun getRetrofitInstance(): RxNewsClient {
    var retrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.API_BASE_URL)
                .client(provideClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

        return retrofit.create(RxNewsClient::class.java)
    }


    private fun provideClient(): OkHttpClient {
            var sHttpClient = OkHttpProvider.provideClient()
        return sHttpClient
    }
}