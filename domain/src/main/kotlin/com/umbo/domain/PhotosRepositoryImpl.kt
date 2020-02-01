package com.umbo.domain

import com.umbo.data.NetworkRepository
import com.umbo.data.Photo

class PhotosRepositoryImpl(
    private val networkRepository: NetworkRepository,
    private val storage: PhotosStorage
): PhotosRepository {

    override fun invalidateCachedData() {
        storage.clearData()
    }

    override suspend fun photos(): List<Photo> {
        return storage.photos ?: networkRepository.photos()?.also {
            storage.replacePhotos(it)
        } ?: emptyList()
    }
}