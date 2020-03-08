package com.umbo.skeleton.core

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.umbo.data.NavigationCommand

abstract class BaseViewModelLiveData<T>() : ViewModel() {

    val liveData: MutableLiveData<T> by lazy {
        MutableLiveData<T>().also {
            start()
        }
    }

    val navigationAction = SingleLiveEvent<NavigationCommand>()

    protected open fun start() {

    }
}
