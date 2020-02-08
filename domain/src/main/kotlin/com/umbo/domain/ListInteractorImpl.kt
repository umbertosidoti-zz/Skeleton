package com.umbo.domain

import com.umbo.data.Outcome
import com.umbo.data.Photo

class ListInteractorImpl(
    private val repository: PhotosRepository
) : ListInteractor {

    override suspend fun photos(): Outcome<List<Photo>> {
        repository.invalidateCachedData()
        return repository.photos()
    }
}