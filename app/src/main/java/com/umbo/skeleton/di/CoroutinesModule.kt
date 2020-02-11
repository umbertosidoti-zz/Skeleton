package com.umbo.skeleton.di

import com.umbo.skeleton.di.corutines.Default
import com.umbo.skeleton.di.corutines.IO
import com.umbo.skeleton.di.corutines.Main
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
    fun provideIODispatchers() : CoroutineDispatcher {
        return Dispatchers.IO
    }

    @Main
    @Provides
    @Singleton
    fun provideMainDispatchers() : CoroutineDispatcher {
        return Dispatchers.Main
    }

    @Default
    @Provides
    @Singleton
    fun provideDefaultDispatchers() : CoroutineDispatcher {
        return Dispatchers.Default
    }
}