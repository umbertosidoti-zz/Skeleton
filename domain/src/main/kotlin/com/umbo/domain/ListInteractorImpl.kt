package com.umbo.domain

import com.umbo.data.Outcome
import com.umbo.data.Photo
import kotlinx.coroutines.delay

class ListInteractorImpl(
    private val repository: PhotosRepository
) : ListInteractor {

    override suspend fun photos(): Outcome<List<Photo>> {
        return repository.photos(false)
    }
}