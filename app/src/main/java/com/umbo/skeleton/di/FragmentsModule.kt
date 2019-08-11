package com.umbo.skeleton.di

import com.umbo.skeleton.list.ListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface FragmentsModule {

    @ContributesAndroidInjector
    fun contributeWeatherFragment(): ListFragment
}