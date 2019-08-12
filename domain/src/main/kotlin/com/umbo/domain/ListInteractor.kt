package com.umbo.domain

import com.umbo.data.Photo

interface ListInteractor {
    suspend fun photos(): List<Photo>?
}