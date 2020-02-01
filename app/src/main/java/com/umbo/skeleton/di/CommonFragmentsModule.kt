package com.umbo.skeleton.di

import com.umbo.data.NetworkRepository
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
    fun providePhotosRepository(networkRepository: NetworkRepository, storage: PhotosStorage): PhotosRepository {
        return PhotosRepositoryImpl(networkRepository, storage)
    }

}