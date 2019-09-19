package com.example.testappua.framework.network

import com.example.testappua.data.models.NewsModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface RxNewsClient {
    @GET("top-headlines")
    fun getNews(@Query("country") country: String = "us", @Query("category") category: String = "entertainment"): Single<NewsModel>
}