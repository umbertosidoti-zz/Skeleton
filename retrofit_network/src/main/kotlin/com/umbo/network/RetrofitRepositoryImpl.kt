package com.umbo.network

import com.umbo.data.NetworkRepository
import com.umbo.data.Photo

class RetrofitRepositoryImpl(private val service: RetrofitService) : NetworkRepository {

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