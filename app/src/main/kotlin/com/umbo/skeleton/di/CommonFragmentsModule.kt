package com.umbo.skeleton.di

import com.umbo.data.Photo
import com.umbo.di.scope.FragmentScope
import com.umbo.domain.repository.PhotosRepository
import com.umbo.domain.repository.PhotosRepositoryImpl
import com.umbo.domain.PhotosStorage
import com.umbo.domain.mapper.Mapper
import com.umbo.domain.mapper.NetworkPhotoToPhotoMapper
import com.umbo.network_interface.NetworkPhoto
import com.umbo.network_interface.NetworkService
import dagger.Module
import dagger.Provides

@Module
class CommonFragmentsModule {

    @Provides
    fun provideNetworkPhotoToPhotoMapper(): Mapper<NetworkPhoto, Photo?> =
        NetworkPhotoToPhotoMapper()

    @Provides
    @FragmentScope
    fun providePhotosRepository(
        networkService: NetworkService,
        storage: PhotosStorage,
        mapper: Mapper<NetworkPhoto, Photo?>
    ): PhotosRepository {
        return PhotosRepositoryImpl(
            networkService,
            storage,
            mapper
        )
    }

}