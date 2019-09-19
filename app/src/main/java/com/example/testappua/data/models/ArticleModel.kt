package com.example.testappua.data.models

data class ArticleModel(
    val source: Source,
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt:String,
    val content: String?
    )