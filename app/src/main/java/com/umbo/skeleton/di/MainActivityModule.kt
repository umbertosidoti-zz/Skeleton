package com.umbo.skeleton.di

import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides

@Module(includes = [FragmentsModule::class])
class MainActivityModule {

    @Provides
    @ActivityScope
    fun provideViewModelProviderFactory(factory: ViewModelProvider.Factory): ViewModelProvidersFactory {
        return ViewModelProvidersFactoryImpl(factory)
    }

}
