package com.umbo.skeleton.di

import com.umbo.skeleton.di.corutines.IO
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
class CoroutinesModule {

    @IO
    @Provides
    @Singleton
    fun provideDispatchers() : CoroutineDispatcher {
        return Dispatchers.IO
    }
}