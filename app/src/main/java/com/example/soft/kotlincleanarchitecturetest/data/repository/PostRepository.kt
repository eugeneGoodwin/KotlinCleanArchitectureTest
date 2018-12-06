package com.example.soft.kotlincleanarchitecturetest.data.repository

import com.example.soft.kotlincleanarchitecturetest.data.mapper.Mapper
import com.example.soft.kotlincleanarchitecturetest.data.mapper.PostMapper
import com.example.soft.kotlincleanarchitecturetest.data.model.Post
import com.example.soft.kotlincleanarchitecturetest.domain.model.DPost
import com.example.soft.kotlincleanarchitecturetest.utils.functional.Either
import javax.inject.Inject

class PostRepository @Inject constructor(private val networkHandler: NetworkHandler,
                                         private val service: NetService,
                                         private val mapper: PostMapper) : NetworkRepository(), PostRepositoryInterface {
    override fun posts(): Either<Error, List<DPost>> {
        return when (networkHandler.isConnected) {
            true -> request(service.getPosts(), { it.map { mapper.mapFromEntity(it) } }, emptyList())
            false, null -> Either.Left(Error.NetworkConnectionError("Network error"))
        }
    }
}