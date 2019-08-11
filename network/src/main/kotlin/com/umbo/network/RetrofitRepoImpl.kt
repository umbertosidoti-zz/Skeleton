package com.umbo.network

import com.umbo.data.NetworkRepo
import com.umbo.data.Post

class RetrofitRepoImpl(private val service: RetrofitService) : NetworkRepo {

    override suspend fun posts(): List<Post> {
        val mapper = NetworkPostToPostMapper()
        val response = service.getPosts()
        return if (response.isSuccessful) {
            response.body()?.map { mapper.map(it) } ?: emptyList()
        } else {
            emptyList<Post>()
        }
    }
}