package com.umbo.skeleton.di.test

import com.umbo.data.corutines.Default
import com.umbo.data.corutines.IO
import com.umbo.data.corutines.Main
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import javax.inject.Singleton

@Module
class TestCoroutinesModule {

    @InternalCoroutinesApi
    @Main
    @Provides
    @Singleton
    fun provideMainDispatchers() : CoroutineDispatcher {
        return CoroutineDispatcherWrapperIdlingResources(Dispatchers.Main)
    }

    @InternalCoroutinesApi
    @Default
    @Provides
    @Singleton
    fun provideDefaultDispatchers() : CoroutineDispatcher {
        return CoroutineDispatcherWrapperIdlingResources(Dispatchers.Default)
    }

    @InternalCoroutinesApi
    @IO
    @Provides
    @Singleton
    fun provideIODispatchers() : CoroutineDispatcher {
        return CoroutineDispatcherWrapperIdlingResources(Dispatchers.IO)
    }

}