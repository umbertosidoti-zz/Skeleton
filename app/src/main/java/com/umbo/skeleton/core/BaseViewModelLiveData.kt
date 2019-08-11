package com.umbo.skeleton.core

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

abstract class BaseViewModelLiveData<T>(): ViewModel() {

    val liveData: MutableLiveData<T> by lazy {
        MutableLiveData<T>().also {
            start()
        }
    }

    protected open fun start() {

    }
}
