package com.example.soft.kotlincleanarchitecturetest.di.module

import com.example.soft.kotlincleanarchitecturetest.di.scopes.PerActivity
import com.example.soft.kotlincleanarchitecturetest.presentation.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBinderModule {
    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(MainActivityModule::class))
    abstract fun mainActivity(): MainActivity
}