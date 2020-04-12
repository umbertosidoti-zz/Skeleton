package com.umbo.skeleton.instancestate

import com.umbo.data.NavigationPayload
import kotlinx.serialization.Serializable

@Serializable
data class PayloadWrapper(val payload: NavigationPayload)