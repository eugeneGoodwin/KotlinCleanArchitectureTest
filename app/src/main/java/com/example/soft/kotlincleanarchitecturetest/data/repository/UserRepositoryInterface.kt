package com.example.soft.kotlincleanarchitecturetest.data.repository

import com.example.soft.kotlincleanarchitecturetest.data.model.User
import com.example.soft.kotlincleanarchitecturetest.domain.model.DUser
import com.example.soft.kotlincleanarchitecturetest.utils.functional.Either

interface UserRepositoryInterface {
    fun users(): Either<Error, List<DUser>>
}