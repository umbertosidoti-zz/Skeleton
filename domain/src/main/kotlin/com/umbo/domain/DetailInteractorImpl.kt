package com.umbo.domain

import com.umbo.data.Photo

class DetailInteractorImpl(private val photosStorage: PhotosStorage): DetailInteractor {

    override fun findPhoto(id: Int): Photo? {
        return photosStorage.photos.find { id == it.id }
    }
}