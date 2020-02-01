package com.umbo.domain

import com.umbo.data.Photo

interface PhotosStorage {
    val photos: List<Photo>
    fun replacePhotos(photos: List<Photo>)
}