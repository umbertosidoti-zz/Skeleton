package com.umbo.skeleton.di

import com.umbo.di.scope.FragmentScope
import com.umbo.skeleton.detail.DetailFragment
import com.umbo.skeleton.list.ListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface FragmentsModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [ListFragmentModule::class, CommonFragmentsModule::class])
    fun contributeListFragment(): ListFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [DetailFragmentModule::class, CommonFragmentsModule::class])
    fun contributeDetailFragment(): DetailFragment
}