package com.umbo.data

interface NetworkRepo {
    suspend fun posts(): List<Post>
}