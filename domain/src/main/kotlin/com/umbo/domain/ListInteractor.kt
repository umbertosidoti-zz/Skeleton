package com.umbo.domain

import com.umbo.data.Post

interface ListInteractor {
    suspend fun posts(): List<Post>?
}