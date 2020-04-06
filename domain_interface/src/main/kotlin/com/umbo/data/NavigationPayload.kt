package com.umbo.data

import kotlinx.serialization.*

sealed class NavigationPayload

object Empty: NavigationPayload()

@Serializable
data class DetailPayload(val id: String): NavigationPayload()

