package com.umbo.domain

import com.umbo.data.Outcome
import com.umbo.data.Photo

interface ListInteractor {
    suspend fun clearData()
    suspend fun photos(): Outcome<List<Photo>>
}