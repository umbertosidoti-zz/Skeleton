package com.umbo.di

import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides

@Module
class ProviderFactoryWrapper {

    @Provides
    fun provideViewModelProviderFactory(factory: ViewModelProvider.Factory): ViewModelProvidersWrapper {
        return ViewModelProvidersWrapperImpl(factory)
    }
}