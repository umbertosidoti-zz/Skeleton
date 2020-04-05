package com.umbo.data

interface DetailInteractor {
    suspend fun findPhoto(): Outcome<Photo>
}