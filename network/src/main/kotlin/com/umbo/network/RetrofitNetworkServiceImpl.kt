package com.umbo.network

import com.umbo.network_interface.NetworkOutcome
import com.umbo.network_interface.NetworkPhoto
import com.umbo.network_interface.NetworkService


class RetrofitNetworkServiceImpl(private val endPoint: RetrofitEndPoint) :
    NetworkService {

    override suspend fun photos(): NetworkOutcome<List<NetworkPhoto>> {
        val response = endPoint.getPhotos("m2i4v9UexChAuvBANfiaPJ3K_3mPFhhCBcKUuWHvlUM")
        val result = if (response.isSuccessful) {
            response.body()
        } else {
            null
        }

        return if (result != null) NetworkOutcome.Success(result) else NetworkOutcome.Error()
    }
}