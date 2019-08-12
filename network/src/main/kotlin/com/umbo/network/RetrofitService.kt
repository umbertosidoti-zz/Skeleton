package com.umbo.network

import retrofit2.Response
import retrofit2.http.GET

interface RetrofitService {

    @GET("/photos")
    suspend fun getPhotos(): Response<List<NetworkPhoto>>

    companion object {
        const val BASE_URL = "https://jsonplaceholder.typicode.com"
    }
}