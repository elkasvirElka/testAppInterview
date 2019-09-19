package ru.elminn.weater_mvvm.di.components

import com.example.testappua.ui.MainActivity
import dagger.Subcomponent


@Subcomponent(modules = [])
interface MainComponent {

    fun injectDayForecastActivity(activity: MainActivity)
}
