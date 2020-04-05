package com.umbo.domain.repository

import com.umbo.data.*
import com.umbo.network_interface.NetworkOutcome
import com.umbo.network_interface.NetworkPhoto
import com.umbo.network_interface.NetworkService

class PhotosRepositoryImpl(
    private val networkService: NetworkService,
    private val storage: PhotosStorage,
    private val mapper: Mapper<NetworkPhoto, Photo?>
) : PhotosRepository {

    override suspend fun photos(dataFromCache: Boolean): Outcome<List<Photo>> {
        return if (dataFromCache) {
            val result = storage.photos
            val cachedPhotos = (result as? Outcome.Success)?.value
            if (cachedPhotos.isNullOrEmpty()) {
                photoFromNetwork().also { outCome ->
                    (outCome as? Outcome.Success)?.let {
                        storage.replacePhotos(it.value)
                    }
                }
            } else {
                result
            }
        } else {
            photoFromNetwork().also { outCome ->
                (outCome as? Outcome.Success)?.let {
                    storage.replacePhotos(it.value)
                }
            }
        }
    }

    private suspend fun photoFromNetwork(): Outcome<List<Photo>> {
        return when(val outcome = networkService.photos()) {
            is NetworkOutcome.Success -> Outcome.Success(outcome.value.mapNotNull { mapper.map(it)})
            is NetworkOutcome.Error -> Outcome.Error()
        }
    }
}