package com.example.testappua.di.module

import com.example.testappua.data.repository.NewsRepository
import com.example.testappua.data.repository.NewsRepositoryImpl
import com.example.testappua.framework.network.RxNewsClient
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Singleton
    @Provides
    fun weaterRepository(client: RxNewsClient): NewsRepository = NewsRepositoryImpl(client)

}
