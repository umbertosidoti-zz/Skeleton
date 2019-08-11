package com.umbo.network

import com.umbo.data.Post

class NetworkPostToPostMapper:Mapper<NetworkPost, Post> {
    override fun map(input: NetworkPost): Post {
        return Post("mapper")
    }
}