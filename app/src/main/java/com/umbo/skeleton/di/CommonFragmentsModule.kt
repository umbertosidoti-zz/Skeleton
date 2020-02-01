package com.umbo.skeleton.di

import com.umbo.data.NetworkService
import com.umbo.di.scope.FragmentScope
import com.umbo.domain.PhotosRepository
import com.umbo.domain.PhotosRepositoryImpl
import com.umbo.domain.PhotosStorage
import dagger.Module
import dagger.Provides

@Module
class CommonFragmentsModule {

    @Provides
    @FragmentScope
    fun providePhotosRepository(networkService: NetworkService, storage: PhotosStorage): PhotosRepository {
        return PhotosRepositoryImpl(networkService, storage)
    }

}