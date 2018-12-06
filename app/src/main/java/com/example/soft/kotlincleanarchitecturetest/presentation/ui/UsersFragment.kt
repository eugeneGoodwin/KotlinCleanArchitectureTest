package com.example.soft.kotlincleanarchitecturetest.presentation.ui

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.soft.kotlincleanarchitecturetest.R
import com.example.soft.kotlincleanarchitecturetest.data.repository.Error
import com.example.soft.kotlincleanarchitecturetest.data.repository.Error.NetworkConnectionError
import com.example.soft.kotlincleanarchitecturetest.data.repository.Error.ServerError
import com.example.soft.kotlincleanarchitecturetest.domain.model.DUser
import com.example.soft.kotlincleanarchitecturetest.presentation.adapters.UsersAdapter
import com.example.soft.kotlincleanarchitecturetest.presentation.viewmodel.UsersViewModel
import com.example.soft.kotlincleanarchitecturetest.utils.extension.observe
import com.example.soft.kotlincleanarchitecturetest.utils.extension.toast
import com.example.soft.kotlincleanarchitecturetest.utils.extension.viewModel
import kotlinx.android.synthetic.main.fragment_users.*
import javax.inject.Inject

class UsersFragment: BaseFragment() {

    @Inject
    lateinit var usersAdapter: UsersAdapter

    private lateinit var usersViewModel: UsersViewModel

    override fun layoutId() = R.layout.fragment_users

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        usersViewModel = viewModel(viewModelFactory) {
            observe(users, ::renderUsersList)
            observe(failure, ::renderError)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeView()
        loadUsersList()
    }

    private fun initializeView() {
        usersList.layoutManager = LinearLayoutManager(context)
        usersList.adapter = usersAdapter
    }

    private fun renderUsersList(dusers: List<DUser>?) {
        usersAdapter.users = dusers.orEmpty()
        hideProgress()
    }

    private fun renderError(fail: Error?) {
        when(fail) {
            is NetworkConnectionError -> toastError("Network connection error", fail)
            is ServerError -> toastError("Server error", fail)
            is Error -> toastError("Error", fail)
        }
        hideProgress()
    }

    private fun toastError(headerMessage: String, fail: Error?) {
        fail?.let { context?.toast(headerMessage + ": " + it.getMessage()) } ?: run { context?.toast(headerMessage) }
    }

    private fun loadUsersList() {
        showProgress()
        usersViewModel.loadUsers()
    }
}