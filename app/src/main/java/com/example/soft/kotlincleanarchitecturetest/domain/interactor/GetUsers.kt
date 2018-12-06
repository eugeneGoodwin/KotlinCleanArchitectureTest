package com.example.soft.kotlincleanarchitecturetest.domain.interactor

import com.example.soft.kotlincleanarchitecturetest.data.repository.UserRepositoryInterface
import com.example.soft.kotlincleanarchitecturetest.domain.model.DUser
import javax.inject.Inject

class GetUsers @Inject constructor(private val repository: UserRepositoryInterface) : UseCase<List<DUser>,UseCase.None>() {
    override suspend fun run(params: None) = repository.users()
}