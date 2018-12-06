package com.example.soft.kotlincleanarchitecturetest.di.module

import android.app.Activity
import android.content.Context
import com.example.soft.kotlincleanarchitecturetest.di.scopes.PerActivity
import dagger.Binds
import dagger.Module

@Module
abstract class BaseActivityModule {
    @Binds
    @PerActivity
    abstract fun activityContext(activity: Activity): Context
}