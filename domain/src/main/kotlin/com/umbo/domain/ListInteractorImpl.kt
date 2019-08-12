package com.umbo.domain

import com.umbo.data.NetworkRepo
import com.umbo.data.Photo

class ListInteractorImpl(private val repo: NetworkRepo) : ListInteractor {
    override var cachedPhotos: List<Photo>? = null

    override suspend fun fetchPhotos(): List<Photo>? {
        cachedPhotos = repo.photos()
        return cachedPhotos
    }
}