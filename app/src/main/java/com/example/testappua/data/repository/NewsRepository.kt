package com.example.testappua.data.repository

import com.example.testappua.data.models.NewsModel
import io.reactivex.Single

interface NewsRepository{
     fun getNews() : Single<NewsModel>
}