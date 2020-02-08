package com.umbo.domain

import com.umbo.data.Outcome
import com.umbo.data.Photo

interface PhotosRepository {
    fun photos(): Outcome<List<Photo>>
    fun invalidateCachedData()
}