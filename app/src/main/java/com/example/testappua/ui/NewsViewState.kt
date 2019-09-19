package com.example.testappua.ui

import com.example.testappua.data.models.ArticleModel

sealed class NewsViewState{
    object Loading : NewsViewState()
    class Success(val article : List<ArticleModel>) : NewsViewState()
    class Failure(val message: String) : NewsViewState()
}