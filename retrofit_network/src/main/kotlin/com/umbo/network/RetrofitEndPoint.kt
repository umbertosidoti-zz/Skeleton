package com.umbo.network

import retrofit2.Response
import retrofit2.http.GET

interface RetrofitEndPoint {

    @GET("/photos")
    fun getPhotos(): Response<List<NetworkPhoto>>

    companion object {
        const val BASE_URL = "https://jsonplaceholder.typicode.com"
    }
}