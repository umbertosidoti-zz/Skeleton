package com.umbo.domain

import com.umbo.data.Photo

interface ListInteractor {
    fun clearData()
    suspend fun photos(): List<Photo>?
}