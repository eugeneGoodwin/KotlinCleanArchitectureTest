package com.example.soft.kotlincleanarchitecturetest.presentation.viewmodel

import android.arch.lifecycle.MutableLiveData
import com.example.soft.kotlincleanarchitecturetest.domain.interactor.GetUsers
import com.example.soft.kotlincleanarchitecturetest.domain.interactor.UseCase
import com.example.soft.kotlincleanarchitecturetest.domain.model.DUser
import javax.inject.Inject

class UsersViewModel @Inject constructor(private val getUsers : GetUsers) : BaseViewModel() {

    var users : MutableLiveData<List<DUser>> = MutableLiveData()

    fun loadUsers() = getUsers(scope, UseCase.None()) { it.fold(::handleFailure, ::handleUsersList)}

    private fun handleUsersList(dusers : List<DUser>) {
        this.users.value = dusers
    }
}