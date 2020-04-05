package com.umbo.data

interface PhotosRepository {
    suspend fun photos(dataFromCache: Boolean = true): Outcome<List<Photo>>
}