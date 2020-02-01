package com.umbo.domain

import com.umbo.data.Photo

class PhotosStorageImpl: PhotosStorage {

    private var storedPhotos: MutableList<Photo>? = null

    override fun replacePhotos(photos: List<Photo>) {
        storedPhotos = mutableListOf()
        storedPhotos?.clear()
        storedPhotos?.addAll(photos)
    }

    override val photos: List<Photo>? = storedPhotos?.toList()

    override fun clearData() {
        storedPhotos = null
    }
}