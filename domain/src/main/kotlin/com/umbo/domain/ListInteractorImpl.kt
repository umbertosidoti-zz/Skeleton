package com.umbo.domain

import com.umbo.data.NetworkRepo
import com.umbo.data.Photo

class ListInteractorImpl(
    private val repo: NetworkRepo,
    private val photosStorage: PhotosStorage
) : ListInteractor {

    override val cachedPhotos: List<Photo>
        get() = photosStorage.photos

    override suspend fun fetchPhotos(): List<Photo>? {
        val photos = repo.photos()
        return photos?.also {
            photosStorage.replacePhotos(it)
        }
    }
}