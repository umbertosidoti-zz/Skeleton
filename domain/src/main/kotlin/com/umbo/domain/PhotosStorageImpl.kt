package com.umbo.domain

import com.umbo.data.Photo

class PhotosStorageImpl: PhotosStorage {
    override val photos: MutableList<Photo> = mutableListOf()
}