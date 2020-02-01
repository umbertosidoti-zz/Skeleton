package com.umbo.data

interface NetworkRepository {
    suspend fun photos(): List<Photo>?
}