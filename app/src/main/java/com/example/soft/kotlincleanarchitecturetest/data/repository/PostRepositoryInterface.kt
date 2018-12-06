package com.example.soft.kotlincleanarchitecturetest.data.repository

import com.example.soft.kotlincleanarchitecturetest.domain.model.DPost
import com.example.soft.kotlincleanarchitecturetest.utils.functional.Either

interface PostRepositoryInterface {
    fun posts(): Either<Error, List<DPost>>
}