package com.example.testappua

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.testappua.data.repository.NewsRepository
import com.example.testappua.ui.NewsViewModel
import com.example.testappua.ui.NewsViewState
import org.junit.Rule
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Test


class NewsViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    @get:Rule
    var trampolineSchedulerRule = TrampolineSchedulerRule()
    private val repository : NewsRepository = mock()
    private val mNewsViewModel: NewsViewModel by lazy { NewsViewModel(repository) }
    var observer: Observer<NewsViewState> = mock()

    @Before
    fun setUp() {
        mNewsViewModel.view.observeForever(observer)
    }

    @Test
    fun testNull() {
        whenever(repository.getNews()).thenReturn(null)
        assertNotNull(mNewsViewModel.getNews())
        assertNotNull(mNewsViewModel.view.hasObservers())
    }

}