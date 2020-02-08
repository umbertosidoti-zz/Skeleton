package com.umbo.domain

import com.umbo.data.NetworkService
import com.umbo.data.Outcome
import com.umbo.data.Photo

class PhotosRepositoryImpl(
    private val networkService: NetworkService,
    private val storage: PhotosStorage
) : PhotosRepository {

    override suspend fun photos(dataFromCache: Boolean): Outcome<List<Photo>> {
        return if (dataFromCache) {
            val result = storage.photos
            val cachedPhotos = (result as? Outcome.Success)?.value
            if (cachedPhotos.isNullOrEmpty()) {
                photoFromNetwork()
            } else {
                result
            }
        } else {
            photoFromNetwork()
        }
    }

    private suspend fun photoFromNetwork(): Outcome<List<Photo>> {
        return networkService.photos().also { photos ->
            (photos as? Outcome.Success)?.value?.let {
                storage.replacePhotos(it)
            }
        }
    }
}