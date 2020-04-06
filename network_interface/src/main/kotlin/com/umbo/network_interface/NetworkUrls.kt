package com.umbo.network_interface

import com.squareup.moshi.Json

data class NetworkUrls (
    @field:Json(name = "regular") val title: String?,
    @field:Json(name = "small") val small: String?,
    @field:Json(name = "thumb") val thumb: String?
)