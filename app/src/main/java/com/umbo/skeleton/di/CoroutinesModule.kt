package com.umbo.skeleton.di

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

@Module()
class CoroutinesModule {

    @Provides
    fun provideCoroutineScope() : CoroutineContext {
        return Dispatchers.IO
    }
}