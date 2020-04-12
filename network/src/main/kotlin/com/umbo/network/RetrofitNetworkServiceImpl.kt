package com.umbo.network

import com.umbo.network_interface.NetworkOutcome
import com.umbo.network_interface.NetworkPhoto
import com.umbo.network_interface.NetworkService


class RetrofitNetworkServiceImpl(
    private val endPoint: RetrofitEndPoint,
    private val clientKey: String
) : NetworkService {

    override suspend fun photos(): NetworkOutcome<List<NetworkPhoto>> {
        return try {
            val response = endPoint.getPhotos(clientKey)
            val result = if (response.isSuccessful) {
                response.body()
            } else {
                null
            }
            if (result != null) NetworkOutcome.Success(result) else NetworkOutcome.Error()
        } catch (e: Exception) {
            NetworkOutcome.Error()
        }
    }
}