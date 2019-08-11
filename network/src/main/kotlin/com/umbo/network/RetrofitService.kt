package com.umbo.network

import retrofit2.Response
import retrofit2.http.GET

interface RetrofitService {

    @GET("/posts")
    suspend fun getPosts(): Response<List<NetworkPost>>

    companion object {
        const val BASE_URL = "https://jsonplaceholder.typicode.com"
    }
}