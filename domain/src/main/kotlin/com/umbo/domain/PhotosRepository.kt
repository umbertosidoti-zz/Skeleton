package com.umbo.domain

import com.umbo.data.Photo

interface PhotosRepository {
    suspend fun photos(): List<Photo>
    fun invalidateCachedData()
}