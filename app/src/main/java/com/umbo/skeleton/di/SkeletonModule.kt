package com.umbo.skeleton.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal object SkeletonModule {
    @Singleton
    @Provides
    @JvmStatic
    fun provideContext(application: Application): Context = application.applicationContext
}
