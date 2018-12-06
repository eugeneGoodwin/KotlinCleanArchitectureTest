package com.example.soft.kotlincleanarchitecturetest.presentation.viewmodel

import android.arch.lifecycle.MutableLiveData
import com.example.soft.kotlincleanarchitecturetest.domain.interactor.GetPosts
import com.example.soft.kotlincleanarchitecturetest.domain.interactor.UseCase.None
import com.example.soft.kotlincleanarchitecturetest.domain.model.DPost
import javax.inject.Inject

class PostsViewModel @Inject constructor(private val getPosts : GetPosts) : BaseViewModel() {

    var posts : MutableLiveData<List<DPost>> = MutableLiveData()

    fun loadPosts() = getPosts(None()) { it.fold(::handleFailure, ::handlePostsList)}

    private fun handlePostsList(dposts : List<DPost>) {
        this.posts.value = dposts
    }
}