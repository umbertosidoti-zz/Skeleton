package com.umbo.network

import com.umbo.data.NetworkService
import com.umbo.data.Outcome
import com.umbo.data.Photo

class RetrofitServiceImpl(private val service: RetrofitService) : NetworkService {

    override suspend fun photos(): Outcome<List<Photo>> {
        val mapper = NetworkPhotoToPhotoMapper()
        val response = service.getPhotos()
        val result = if (response.isSuccessful) {
            response.body()?.mapNotNull { mapper.map(it) }
        } else {
            null
        }

        return if (result != null) Outcome.Success(result) else Outcome.Error("error")
    }
}