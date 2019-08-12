package com.umbo.network

import com.umbo.data.NetworkRepo
import com.umbo.data.Photo

class RetrofitRepoImpl(private val service: RetrofitService) : NetworkRepo {

    override suspend fun photos(): List<Photo>? {
        val mapper = NetworkPhotoToPhotoMapper()
        val response = service.getPhotos()
        return if (response.isSuccessful) {
            response.body()?.mapNotNull { mapper.map(it) } ?: emptyList()
        } else {
            null
        }
    }
}