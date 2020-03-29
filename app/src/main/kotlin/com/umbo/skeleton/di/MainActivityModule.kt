package com.umbo.skeleton.di

import com.umbo.di.ProviderFactoryWrapper
import com.umbo.di.scope.ActivityScope
import com.umbo.data.PhotosStorage
import com.umbo.data.Router
import com.umbo.domain.PhotosStorageImpl
import com.umbo.skeleton.routing.RouterImpl
import dagger.Module
import dagger.Provides

@Module(includes = [
    ProviderFactoryWrapper::class,
    FragmentsModule::class])
class MainActivityModule {

    @ActivityScope
    @Provides
    fun providePhotoStorage(): PhotosStorage = PhotosStorageImpl()

    @ActivityScope
    @Provides
    fun provideRouter(): Router = RouterImpl()
}
