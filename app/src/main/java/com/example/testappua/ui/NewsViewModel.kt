package com.example.testappua.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testappua.data.repository.NewsRepository
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class NewsViewModel @Inject constructor(private val repository: NewsRepository)
    : ViewModel(){
    private val compositeDisposable = CompositeDisposable()

    private val _viewState = MutableLiveData<NewsViewState>()
    val view : LiveData<NewsViewState>
        get() = _viewState

    fun action(action: NewsAction) {
        when (action) {
            is NewsAction.FetchNews -> getNews()
        }
    }
    private fun getNews(){
        compositeDisposable.add(
            repository.getNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { _viewState.value = NewsViewState.Loading }
                .subscribe (
                    { _viewState.value = NewsViewState.Success(it.articles) },
                    {
                        _viewState.value =
                            NewsViewState.Failure(it.message ?: "")
                    })
        )

    }
}