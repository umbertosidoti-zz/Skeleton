package com.umbo.skeleton.di

import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides

@Module(includes = [FragmentsModule::class])
class MainActivityModule {

    @Provides
    fun provideViewModelProviderFactory(factory: ViewModelProvider.Factory): ViewModelProvidersWrapper {
        return ViewModelProvidersWrapperImpl(factory)
    }

}
