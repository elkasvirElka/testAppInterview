package com.example.testappua.data.repository

import com.example.testappua.data.models.NewsModel
import com.example.testappua.framework.network.RxNewsClient
import io.reactivex.Single
import javax.inject.Inject

class NewsRepositoryImpl@Inject constructor(private val client: RxNewsClient) : NewsRepository{

    override fun getNews(): Single<NewsModel> {
        return client.getNews()
    }

}