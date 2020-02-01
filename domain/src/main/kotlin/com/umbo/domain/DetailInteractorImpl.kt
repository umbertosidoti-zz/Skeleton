package com.umbo.domain

import com.umbo.data.Photo

class DetailInteractorImpl(private val photosRepository: PhotosRepository): DetailInteractor {

    override suspend fun findPhoto(id: Int): Photo? {
        return photosRepository.photos().find { id == it.id }
    }
}