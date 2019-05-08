package com.example.soft.kotlincleanarchitecturetest.domain.interactor

import com.example.soft.kotlincleanarchitecturetest.data.repository.Error
import com.example.soft.kotlincleanarchitecturetest.utils.functional.Either
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

abstract class UseCase<out Type, in Params> where Type : Any {

    abstract suspend fun run(params: Params): Either<Error, Type>

    operator fun invoke(scope: CoroutineScope, params: Params, onResult: (Either<Error, Type>) -> Unit = {}) = with(scope) {
        val job = async(Dispatchers.Default) { run(params) }
        launch(Dispatchers.Main) { onResult(job.await()) }
    }

    class None
}