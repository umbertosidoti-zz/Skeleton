package com.umbo.data

interface NavigationPayloadRepository {

    val payload: NavigationPayload

    fun updatePayload(payload: NavigationPayload)
}