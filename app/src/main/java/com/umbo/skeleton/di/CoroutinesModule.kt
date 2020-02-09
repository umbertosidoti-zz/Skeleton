package com.umbo.skeleton.di

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

@Module()
class CoroutinesModule {

    @Provides
    fun provideCoroutineScope() : CoroutineScope {
        return CoroutineScope(Dispatchers.IO)
    }
}