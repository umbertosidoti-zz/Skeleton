package com.umbo.skeleton.di

import com.umbo.data.ImageLoader
import com.umbo.image_loader.GlideImageLoader
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
object GlideModule {

    @Singleton
    @Provides
    @JvmStatic
    fun provideGlideImageLoader(): ImageLoader {
        return GlideImageLoader()
    }
}