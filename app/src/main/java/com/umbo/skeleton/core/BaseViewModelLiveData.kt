package com.umbo.skeleton.core

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModelLiveData<T>(): ViewModel() {

    val liveData: MutableLiveData<T> by lazy {
        MutableLiveData<T>().also {
            start()
        }
    }

    protected fun start() {

    }
}
