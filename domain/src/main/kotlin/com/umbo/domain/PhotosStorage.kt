package com.umbo.domain

import com.umbo.data.Photo

interface PhotosStorage {
    val photos: MutableList<Photo>
}