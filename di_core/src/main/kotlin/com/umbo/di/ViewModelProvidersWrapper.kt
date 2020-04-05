package com.umbo.di

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

interface ViewModelProvidersWrapper {
    fun of(activity: AppCompatActivity): ViewModelProvider
    fun of(fragment: Fragment): ViewModelProvider
}

class ViewModelProvidersWrapperImpl(private val factory: ViewModelProvider.Factory):
    ViewModelProvidersWrapper {

    override fun of(fragment: Fragment): ViewModelProvider {
        return ViewModelProvider(fragment, factory)
    }

    override fun of(activity: AppCompatActivity): ViewModelProvider {
        return ViewModelProvider(activity, factory)
    }

}