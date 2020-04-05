package com.umbo.domain.repository

import com.umbo.data.Empty
import com.umbo.data.NavigationPayload
import com.umbo.data.NavigationPayloadRepository

class NavigationPayloadRepositoryImpl : NavigationPayloadRepository {

    private var navigationPayload: NavigationPayload = Empty

    override val payload: NavigationPayload
        get() = navigationPayload

    override fun updatePayload(payload: NavigationPayload) {
        navigationPayload = payload
    }
}