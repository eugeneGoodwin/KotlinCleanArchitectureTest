package com.example.soft.kotlincleanarchitecturetest.presentation.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.soft.kotlincleanarchitecturetest.data.repository.Error
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancelChildren

open class BaseViewModel : ViewModel() {

    private val job = SupervisorJob()
    protected val scope = CoroutineScope(Dispatchers.Default + job)

    var failure : MutableLiveData<Error> = MutableLiveData()

    protected fun handleFailure(fail : Error) {
        this.failure.value = fail
    }

    protected fun cancelAllWork() = scope.coroutineContext.cancelChildren()

    override fun onCleared() {
        cancelAllWork()
        super.onCleared()
    }
}