package com.umbo.domain.interactor

import com.umbo.data.*

class DetailInteractorImpl(
    private val photosRepository: PhotosRepository,
    private val navigationPayloadRepository: NavigationPayloadRepository
) : DetailInteractor {

    override suspend fun findPhoto(): Outcome<Photo> {
        val id = (navigationPayloadRepository.payload as? DetailPayload)?.id ?: return Outcome.Error()
        val outcome = photosRepository.photos()
        val photos = (outcome as? Outcome.Success)
        val selected = photos?.value?.find { id == it.id }
        return if (selected != null) Outcome.Success(selected) else Outcome.Error()
    }
}