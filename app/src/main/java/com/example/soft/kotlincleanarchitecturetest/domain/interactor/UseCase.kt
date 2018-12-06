package com.example.soft.kotlincleanarchitecturetest.domain.interactor

import com.example.soft.kotlincleanarchitecturetest.data.repository.Error
import com.example.soft.kotlincleanarchitecturetest.utils.functional.Either
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch

abstract class UseCase<out Type, in Params> where Type : Any {

    abstract suspend fun run(params: Params): Either<Error, Type>

    operator fun invoke(params: Params, onResult: (Either<Error, Type>) -> Unit = {}) {
        val job = async(CommonPool) { run(params) }
        launch(UI) { onResult(job.await()) }
    }

    class None
}