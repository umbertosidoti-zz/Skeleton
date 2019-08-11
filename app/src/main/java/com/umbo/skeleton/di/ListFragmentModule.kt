package com.umbo.skeleton.di

import androidx.lifecycle.ViewModelProvider
import com.umbo.skeleton.list.ListViewState
import dagger.Module
import dagger.Provides

@Module(includes = [ListFragmentModule.Bind::class,  ViewModelFactoryModule::class])
class ListFragmentModule {

    @Provides
    fun provideViewModelProviderFactory(factory: ViewModelProvider.Factory): ViewModelProvidersWrapper {
        return ViewModelProvidersWrapperImpl(factory)
    }

    @Provides
    fun provideListViewState()= ListViewState("test")


    @Module
    interface Bind {


    }
}