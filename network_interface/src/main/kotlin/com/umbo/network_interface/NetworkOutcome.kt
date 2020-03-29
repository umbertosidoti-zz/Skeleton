package com.umbo.network_interface

sealed class NetworkOutcome<out T : Any> {
    data class Success<out T : Any>(val value: T) : NetworkOutcome<T>()
    data class Error(val cause: Exception? = null) : NetworkOutcome<Nothing>()
}