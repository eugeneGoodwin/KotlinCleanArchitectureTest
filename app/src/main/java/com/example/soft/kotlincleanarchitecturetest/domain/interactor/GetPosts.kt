package com.example.soft.kotlincleanarchitecturetest.domain.interactor

import com.example.soft.kotlincleanarchitecturetest.data.repository.PostRepositoryInterface
import com.example.soft.kotlincleanarchitecturetest.domain.model.DPost
import javax.inject.Inject

class GetPosts @Inject constructor(private val repository: PostRepositoryInterface) : UseCase<List<DPost>,UseCase.None>() {
    override suspend fun run(params: None) = repository.posts()
}