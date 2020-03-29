package com.umbo.domain.interactor

import com.umbo.data.Outcome
import com.umbo.data.Photo

interface DetailInteractor {
    suspend fun findPhoto(id: Int): Outcome<Photo>
}