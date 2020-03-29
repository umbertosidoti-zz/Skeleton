package com.umbo.network_interface

interface NetworkService {
    suspend fun photos(): NetworkOutcome<List<NetworkPhoto>>
}