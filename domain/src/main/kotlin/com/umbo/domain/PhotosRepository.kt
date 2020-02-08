package com.umbo.domain

import com.umbo.data.Outcome
import com.umbo.data.Photo

interface PhotosRepository {
    suspend fun photos(dataFromCache: Boolean = true): Outcome<List<Photo>>
}