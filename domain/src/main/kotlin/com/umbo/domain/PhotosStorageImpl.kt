package com.umbo.domain

import com.umbo.data.Photo

class PhotosStorageImpl: PhotosStorage {

    private val storedPhotos: MutableList<Photo> = mutableListOf()

    override fun replacePhotos(photos: List<Photo>) {
        storedPhotos.clear()
        storedPhotos.addAll(photos)
    }

    override val photos: List<Photo> = storedPhotos.toList()
}