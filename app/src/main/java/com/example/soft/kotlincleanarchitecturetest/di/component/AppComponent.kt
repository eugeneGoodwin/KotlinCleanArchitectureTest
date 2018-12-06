package com.example.soft.kotlincleanarchitecturetest.di.component

import android.app.Application
import com.example.soft.kotlincleanarchitecturetest.App
import com.example.soft.kotlincleanarchitecturetest.di.module.AppModule
import com.example.soft.kotlincleanarchitecturetest.di.module.IOModule
import com.example.soft.kotlincleanarchitecturetest.di.module.ActivityBinderModule
import com.example.soft.kotlincleanarchitecturetest.di.viewmodel.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
        modules = [
            AndroidSupportInjectionModule::class,
            AppModule::class,
            IOModule::class,
            ViewModelModule::class,
            ActivityBinderModule::class
        ]
)
interface AppComponent: AndroidInjector<App> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun app(app: Application): Builder
        fun ioModule(module:IOModule): Builder
        fun build(): AppComponent
    }
}