package com.umbo.domain

import com.umbo.data.Outcome
import com.umbo.data.Photo

class DetailInteractorImpl(private val photosRepository: PhotosRepository): DetailInteractor {

    override suspend fun findPhoto(id: Int): Outcome<Photo> {
        val selected = (photosRepository.photos() as? Outcome.Success)?.value?.find { id == it.id }
        return if (selected != null) Outcome.Success(selected) else Outcome.Error("error")
    }
}