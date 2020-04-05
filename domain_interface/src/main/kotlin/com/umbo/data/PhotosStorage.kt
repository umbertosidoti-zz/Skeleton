package com.umbo.data

interface PhotosStorage {
    val photos: Outcome<List<Photo>>
    fun replacePhotos(photos: List<Photo>)
    fun clearData()
}