package com.umbo.presentation.core

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.umbo.data.NavigationCommand
import com.umbo.data.corutines.IO
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

abstract class BaseViewModelLiveData<T>(private val dispatcher: CoroutineDispatcher) :
    ViewModel() {

    val liveData: MutableLiveData<T> by lazy {
        MutableLiveData<T>().also {
            start()
        }
    }

    val navigationAction = SingleLiveEvent<NavigationCommand>()

    protected open fun start() {

    }

    fun doAsync(function: suspend () -> (Unit)) {
        viewModelScope.launch(dispatcher) {
            function.invoke()
        }
    }
}
