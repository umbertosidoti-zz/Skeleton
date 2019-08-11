package com.umbo.domain

import com.umbo.data.NetworkRepo
import com.umbo.data.Post

class ListInteractorImpl(private val repo: NetworkRepo) : ListInteractor {
    override suspend fun posts(): List<Post>? {
        return repo.posts()
    }
}