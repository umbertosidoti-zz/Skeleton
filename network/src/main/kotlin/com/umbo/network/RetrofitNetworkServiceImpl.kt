package com.umbo.network

import com.umbo.network_interface.NetworkOutcome
import com.umbo.network_interface.NetworkPhoto
import com.umbo.network_interface.NetworkService


class RetrofitNetworkServiceImpl(private val endPoint: RetrofitEndPoint, private val clientKey: String) :
    NetworkService {

    override suspend fun photos(): NetworkOutcome<List<NetworkPhoto>> {

        val response = endPoint.getPhotos(clientKey)
        val result = if (response.isSuccessful) {
            response.body()
        } else {
            null
        }

        return if (result != null) NetworkOutcome.Success(result) else NetworkOutcome.Error()
    }
}