package com.umbo.data

import kotlinx.serialization.*

interface NavigationPayload

@Serializable
object Empty: NavigationPayload

@Serializable
data class DetailPayload(val id: String): NavigationPayload

