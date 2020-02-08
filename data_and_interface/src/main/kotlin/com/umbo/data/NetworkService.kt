package com.umbo.data

interface NetworkService {
    suspend fun photos(): Outcome<List<Photo>>
}