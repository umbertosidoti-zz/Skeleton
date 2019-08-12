package com.umbo.data

interface NetworkRepo {
    suspend fun photos(): List<Photo>?
}