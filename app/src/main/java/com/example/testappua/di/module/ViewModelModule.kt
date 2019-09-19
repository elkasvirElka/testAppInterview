package com.example.testappua.di.module

import androidx.lifecycle.ViewModel
import com.example.testappua.di.ViewModelKey
import com.example.testappua.ui.NewsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(NewsViewModel::class)
    abstract fun provideDayForecastViewModel(viewModel: NewsViewModel): ViewModel
}