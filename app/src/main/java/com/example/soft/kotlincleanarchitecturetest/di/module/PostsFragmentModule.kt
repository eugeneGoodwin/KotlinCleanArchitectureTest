package com.example.soft.kotlincleanarchitecturetest.di.module

import android.support.v7.widget.RecyclerView
import com.example.soft.kotlincleanarchitecturetest.di.scopes.PerFragment
import com.example.soft.kotlincleanarchitecturetest.presentation.adapters.PostsAdapter
import dagger.Binds
import dagger.Module

@Module
abstract class PostsFragmentModule {
    @Binds
    @PerFragment
    abstract fun providePostsAdapter(postsAdapter: PostsAdapter) : RecyclerView.Adapter<PostsAdapter.ViewHolder>
}