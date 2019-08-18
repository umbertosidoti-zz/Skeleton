package com.umbo.data

import java.io.Serializable

enum class Destination {
    DETAIL
}

data class NavigationCommand(val destination: Destination, val payload: Serializable? = null)