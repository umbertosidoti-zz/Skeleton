package com.umbo.domain

import com.umbo.data.NetworkRepo
import com.umbo.data.Photo

class ListInteractorImpl(private val repo: NetworkRepo) : ListInteractor {
    override suspend fun photos(): List<Photo>? {
        return repo.photos()
    }
}