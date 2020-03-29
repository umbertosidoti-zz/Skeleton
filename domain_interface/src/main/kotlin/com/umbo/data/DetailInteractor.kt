package com.umbo.data

interface DetailInteractor {
    suspend fun findPhoto(id: Int): Outcome<Photo>
}