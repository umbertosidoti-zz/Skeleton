package com.umbo.domain.interactor

import com.umbo.data.*

class ListInteractorImpl(
    private val repository: PhotosRepository
) : ListInteractor {

    override suspend fun photos(): Outcome<List<Photo>> {
        return repository.photos(false)
    }

    override suspend fun navigationPayload(id: Int): Outcome<DetailPayload> {
        return (repository.photos(true) as? Outcome.Success)?.value?.find { it.id == id }?.let {
            Outcome.Success(DetailPayload(it.id))
        } ?: Outcome.Error()
    }
}