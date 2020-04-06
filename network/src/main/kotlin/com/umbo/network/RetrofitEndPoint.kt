package com.umbo.network

import com.umbo.network_interface.NetworkPhoto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitEndPoint {

    @GET("/photos")
    suspend fun getPhotos(@Query("client_id") client: String): Response<List<NetworkPhoto>>

    companion object {
        const val BASE_URL = "https://api.unsplash.com/"
    }
}