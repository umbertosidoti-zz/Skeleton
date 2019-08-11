package com.umbo.skeleton.di

import com.umbo.skeleton.list.ListViewState
import dagger.Module
import dagger.Provides

@Module
class ListFragmentModule {

    @Provides
    fun provideListViewState()= ListViewState("test")
}