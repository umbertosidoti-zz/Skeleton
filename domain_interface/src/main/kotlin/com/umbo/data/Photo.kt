package com.umbo.data

data class Photo(
    val id: String,
    val user: String,
    val width: Int,
    val height: Int,
    val description: String?,
    val url: String,
    val thumbnailUrl: String
)