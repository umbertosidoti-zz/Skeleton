package com.umbo.domain

import com.umbo.data.Photo

class ListInteractorImpl(
    private val repository: PhotosRepository
) : ListInteractor {

    override suspend fun clearData() {
        repository.invalidateCachedData()
    }

    override suspend fun photos(): List<Photo>? {
        return repository.photos()
    }
}