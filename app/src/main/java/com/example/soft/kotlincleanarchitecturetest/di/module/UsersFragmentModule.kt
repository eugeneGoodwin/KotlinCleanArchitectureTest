package com.example.soft.kotlincleanarchitecturetest.di.module

import com.example.soft.kotlincleanarchitecturetest.di.scopes.PerFragment
import com.example.soft.kotlincleanarchitecturetest.presentation.adapters.UsersAdapter
import dagger.Module
import dagger.Provides

@Module
abstract class UsersFragmentModule {
    @Module
    companion object {
        @Provides
        @PerFragment
        fun provideUsersAdapter() = UsersAdapter()
    }
}