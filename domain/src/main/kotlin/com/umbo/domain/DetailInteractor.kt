package com.umbo.domain

import com.umbo.data.Photo

interface DetailInteractor {
    fun findPhoto(id: Int): Photo?
}