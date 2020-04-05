package com.umbo.presentation.core

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.umbo.data.NavigationCommand
import com.umbo.data.Navigator
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

abstract class BaseViewModelLiveData<T>(protected val dispatcher: CoroutineDispatcher, private val navigator: Navigator) :
    ViewModel() {

    private val mutableLiveData: MutableLiveData<T> by lazy {
        MutableLiveData<T>().also {
            onStart()
        }
    }

    val liveData: LiveData<T> get() =  mutableLiveData

    protected open fun onStart() {

    }

    fun doAsync(function: suspend () -> (Unit)) {
        viewModelScope.launch {
            withContext(dispatcher) {
                function.invoke()
            }
        }
    }

    fun postValue(value: T) {
        mutableLiveData.postValue(value)
    }

    fun routeTo(action: NavigationCommand) {
        navigator.routeTo(action)
    }
}
