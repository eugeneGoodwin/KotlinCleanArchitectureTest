package com.example.soft.kotlincleanarchitecturetest.presentation.ui

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.soft.kotlincleanarchitecturetest.R
import com.example.soft.kotlincleanarchitecturetest.data.repository.Error
import com.example.soft.kotlincleanarchitecturetest.domain.model.DPost
import com.example.soft.kotlincleanarchitecturetest.presentation.adapters.PostsAdapter
import com.example.soft.kotlincleanarchitecturetest.presentation.viewmodel.PostsViewModel
import com.example.soft.kotlincleanarchitecturetest.utils.extension.observe
import com.example.soft.kotlincleanarchitecturetest.utils.extension.toast
import com.example.soft.kotlincleanarchitecturetest.utils.extension.viewModel
import kotlinx.android.synthetic.main.fragment_posts.*
import javax.inject.Inject

class PostsFragment : BaseFragment() {

    @Inject
    lateinit var postsAdapter: PostsAdapter

    private lateinit var postsViewModel: PostsViewModel

    override fun layoutId() = R.layout.fragment_posts

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        postsViewModel = viewModel(viewModelFactory) {
            observe(posts, ::renderPostsList)
            observe(failure, ::renderError)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeView()
        loadPostsList()
    }

    private fun initializeView() {
        postsList.layoutManager = LinearLayoutManager(context)
        postsList.adapter = postsAdapter
    }

    private fun renderPostsList(dposts: List<DPost>?) {
        postsAdapter.posts = dposts.orEmpty()
        hideProgress()
    }

    private fun renderError(fail: Error?) {
        fail?.getMessage()?.let { context?.toast(it) }
        hideProgress()
    }

    private fun loadPostsList() {
        showProgress()
        postsViewModel.loadPosts()
    }
}