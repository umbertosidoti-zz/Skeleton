package com.umbo.network_interface

import com.squareup.moshi.Json

data class NetworkUser (
    @field:Json(name = "id") val id: String?,
    @field:Json(name = "username") val username: String?,
    @field:Json(name = "instagram_username") val instagram_username: String?
)