package com.example.testappua.di.module

import com.example.testappua.data.repository.NewsRepository
import com.example.testappua.data.repository.NewsRepositoryImpl
import com.example.testappua.framework.network.ApiFactory
import com.example.testappua.framework.network.RxNewsClient

object InjectorUtils{
    fun provideRepositoryViewModel() : NewsRepository {
        var repository =
            NewsRepositoryImpl(ApiFactory.getRetrofitInstance().create((RxNewsClient::class.java)))
        return repository
    }
}