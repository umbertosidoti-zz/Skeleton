package com.umbo.network_interface

import com.squareup.moshi.Json

data class NetworkPhoto(
    @field:Json(name = "id") val id: String?,
    @field:Json(name = "width") val width: Int?,
    @field:Json(name = "height") val height: Int?,
    @field:Json(name = "description") val description: String?,
    @field:Json(name = "likes") val likes: Int?,
    @field:Json(name = "urls") val urls: NetworkUrls?
)