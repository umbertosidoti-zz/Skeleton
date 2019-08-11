package com.umbo.skeleton.di

import com.umbo.skeleton.list.ListViewState
import dagger.Module
import dagger.Provides

@Module(includes = [ListFragmentModule.Bind::class])
class ListFragmentModule {

    @Provides
    fun provideListViewState()= ListViewState("test")


    @Module
    interface Bind {


    }
}