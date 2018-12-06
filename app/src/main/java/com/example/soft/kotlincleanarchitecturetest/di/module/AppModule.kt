package com.example.soft.kotlincleanarchitecturetest.di.module

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.example.soft.kotlincleanarchitecturetest.data.repository.PostRepository
import com.example.soft.kotlincleanarchitecturetest.data.repository.PostRepositoryInterface
import com.example.soft.kotlincleanarchitecturetest.data.repository.UserRepository
import com.example.soft.kotlincleanarchitecturetest.data.repository.UserRepositoryInterface
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule() {

    @Provides @Singleton fun provideApplicationContext(app: Application): Context = app
    @Provides @Singleton fun provideSharedPreference(app: Application): SharedPreferences = PreferenceManager.getDefaultSharedPreferences(app)
    @Provides @Singleton fun provideUserRepository(dataSource: UserRepository): UserRepositoryInterface = dataSource
    @Provides @Singleton fun providePostRepository(dataSource: PostRepository): PostRepositoryInterface = dataSource
}