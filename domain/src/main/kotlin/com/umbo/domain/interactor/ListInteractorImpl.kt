package com.umbo.domain.interactor

import com.umbo.data.Outcome
import com.umbo.data.Photo
import com.umbo.domain.repository.PhotosRepository

class ListInteractorImpl(
    private val repository: PhotosRepository
) : ListInteractor {

    override suspend fun photos(): Outcome<List<Photo>> {
        return repository.photos(false)
    }
}