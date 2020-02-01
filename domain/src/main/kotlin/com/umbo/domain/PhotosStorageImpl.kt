package com.umbo.domain

import com.umbo.data.Outcome
import com.umbo.data.Photo

class PhotosStorageImpl: PhotosStorage {

    private var storedPhotos: MutableList<Photo> = mutableListOf()

    override fun replacePhotos(photos: List<Photo>) {
        storedPhotos.clear()
        storedPhotos.addAll(photos)
    }

    override val photos: Outcome<List<Photo>>
        get() = Outcome.Success(storedPhotos)

    override fun clearData() {
        storedPhotos.clear()
    }
}