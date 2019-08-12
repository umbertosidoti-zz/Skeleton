package com.umbo.di.image

import com.umbo.data_android.ImageLoader
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