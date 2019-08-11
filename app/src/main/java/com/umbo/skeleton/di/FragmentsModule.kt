package com.umbo.skeleton.di

import com.umbo.di.scope.FragmentScope
import com.umbo.skeleton.list.ListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface FragmentsModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [ListFragmentModule::class])
    fun contributeWeatherFragment(): ListFragment
}