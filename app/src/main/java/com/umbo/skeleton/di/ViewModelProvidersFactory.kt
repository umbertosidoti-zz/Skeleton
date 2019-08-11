package com.umbo.skeleton.di

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

interface ViewModelProvidersFactory {
    fun of(activity: AppCompatActivity): ViewModelProvider
    fun of(fragment: Fragment): ViewModelProvider
}

class ViewModelProvidersFactoryImpl(private val factory: ViewModelProvider.Factory): ViewModelProvidersFactory {

    override fun of(fragment: Fragment): ViewModelProvider {
        return ViewModelProviders.of(fragment, factory)
    }

    override fun of(activity: AppCompatActivity): ViewModelProvider {
        return ViewModelProviders.of(activity, factory)
    }

}