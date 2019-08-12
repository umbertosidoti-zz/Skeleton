package com.umbo.domain

import com.umbo.data.Photo

interface ListInteractor {
    suspend fun fetchPhotos(): List<Photo>?
    val cachedPhotos: List<Photo>?
}