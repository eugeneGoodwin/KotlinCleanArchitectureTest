package com.example.soft.kotlincleanarchitecturetest.data.repository

import com.example.soft.kotlincleanarchitecturetest.data.mapper.UserMapper
import com.example.soft.kotlincleanarchitecturetest.data.repository.Error.NetworkConnectionError
import com.example.soft.kotlincleanarchitecturetest.domain.model.DUser
import com.example.soft.kotlincleanarchitecturetest.utils.functional.Either
import javax.inject.Inject


class UserRepository @Inject constructor(private val networkHandler: NetworkHandler,
                                         private val service: NetService,
                                         private val mapper: UserMapper) : NetworkRepository(), UserRepositoryInterface {
    override fun users(): Either<Error, List<DUser>> {
        return when (networkHandler.isConnected) {
            true -> request(service.getUsers(), { it.map { mapper.mapFromEntity(it) } }, emptyList())
            false, null -> Either.Left(NetworkConnectionError("No connection"))
        }
    }
}