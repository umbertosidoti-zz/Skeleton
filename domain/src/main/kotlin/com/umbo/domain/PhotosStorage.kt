package com.umbo.domain

import com.umbo.data.Outcome
import com.umbo.data.Photo

interface PhotosStorage {
    val photos: Outcome<List<Photo>>
    fun replacePhotos(photos: List<Photo>)
    fun clearData()
}