package com.umbo.data


enum class Destination {
    DETAIL
}

data class NavigationCommand(val destination: Destination, val payload: NavigationPayload? = null)