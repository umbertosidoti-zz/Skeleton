package com.umbo.presentation.core

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.umbo.data.NavigationCommand
import com.umbo.data.Navigator
import com.umbo.data.corutines.IO
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

abstract class BaseViewModelLiveData<T>(private val dispatcher: CoroutineDispatcher, private val navigator: Navigator) :
    ViewModel() {

    val liveData: LiveData<T> get() =  mutableLiveData

    protected val mutableLiveData: MutableLiveData<T> by lazy {
        MutableLiveData<T>().also {
            start()
        }
    }

    protected open fun start() {

    }

    fun doAsync(function: suspend () -> (Unit)) {
        viewModelScope.launch(dispatcher) {
            function.invoke()
        }
    }

    fun routeTo(action: NavigationCommand) {
        navigator.routeTo(action)
    }
}
