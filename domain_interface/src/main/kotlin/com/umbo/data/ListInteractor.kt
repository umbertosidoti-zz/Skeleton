package com.umbo.data

import com.umbo.data.Outcome
import com.umbo.data.Photo

interface ListInteractor {
    suspend fun photos(): Outcome<List<Photo>>
}