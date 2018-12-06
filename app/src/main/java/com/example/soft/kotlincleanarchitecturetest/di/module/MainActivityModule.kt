package com.example.soft.kotlincleanarchitecturetest.di.module

import dagger.android.ContributesAndroidInjector
import com.example.soft.kotlincleanarchitecturetest.di.scopes.PerFragment
import com.example.soft.kotlincleanarchitecturetest.presentation.ui.PostsFragment
import com.example.soft.kotlincleanarchitecturetest.presentation.ui.UsersFragment
import dagger.Module


@Module(includes = arrayOf(BaseActivityModule::class))
abstract class MainActivityModule {
    @PerFragment
    @ContributesAndroidInjector(modules = arrayOf(UsersFragmentModule::class))
    internal abstract fun usersFragmentInjector(): UsersFragment

    @PerFragment
    @ContributesAndroidInjector(modules = arrayOf(PostsFragmentModule::class))
    internal abstract fun postsFragmentInjector(): PostsFragment
}