package ru.elminn.weater_mvvm.di.components

import com.example.testappua.di.module.DataModule
import com.example.testappua.di.module.FrameworkModule
import com.example.testappua.di.module.ViewModelModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DataModule::class, FrameworkModule::class, ViewModelModule::class])
interface AppComponent {

    fun createMainComponent(): MainComponent

}