package com.umbo.skeleton.di

import com.umbo.data.NavigationPayloadRepository
import com.umbo.di.ProviderFactoryWrapper
import com.umbo.di.scope.ActivityScope
import com.umbo.data.PhotosStorage
import com.umbo.data.Router
import com.umbo.domain.PhotosStorageImpl
import com.umbo.domain.repository.NavigationPayloadRepositoryImpl
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
    fun provideNavigationPayloadRepository() : NavigationPayloadRepository = NavigationPayloadRepositoryImpl()

    @ActivityScope
    @Provides
    fun provideRouter(navigationPayloadRepository: NavigationPayloadRepository): Router = RouterImpl(navigationPayloadRepository)
}
