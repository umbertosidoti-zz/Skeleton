package com.umbo.skeleton.core

sealed class ViewStateOutcome<out T : Any> {
    data class Success<out T : Any>(val value: T) : ViewStateOutcome<T>()
    data class Error(val message: String, val cause: Exception? = null) : ViewStateOutcome<Nothing>()
}