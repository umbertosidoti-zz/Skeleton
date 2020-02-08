package com.umbo.network

import com.umbo.data.NetworkService
import com.umbo.data.Outcome
import com.umbo.data.Photo

class RetrofitNetworkServiceImpl(private val endPoint: RetrofitEndPoint) : NetworkService {

    override suspend fun photos(): Outcome<List<Photo>> {
        val mapper = NetworkPhotoToPhotoMapper()
        val response = endPoint.getPhotos()
        val result = if (response.isSuccessful) {
            response.body()?.mapNotNull { mapper.map(it) }
        } else {
            null
        }

        return if (result != null) Outcome.Success(result) else Outcome.Error()
    }
}