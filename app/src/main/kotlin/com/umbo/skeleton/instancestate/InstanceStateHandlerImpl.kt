package com.umbo.skeleton.instancestate

import android.os.Bundle
import com.umbo.data.NavigationPayloadRepository
import kotlinx.serialization.json.Json

class InstanceStateHandlerImpl(private val json: Json, private val repository: NavigationPayloadRepository) : InstanceStateHandler {

    private val RouterData: String = "routerData"

    override fun onSaveInstanceState(outState: Bundle) {
        val serialized = json.stringify(PayloadWrapper.serializer(), PayloadWrapper(repository.payload))
        outState.putString(RouterData, serialized)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        savedInstanceState?.let { bundle ->
            val stringData =  bundle.getString(RouterData)
            stringData?.let { data ->
                val routerData: PayloadWrapper? = json.parse(PayloadWrapper.serializer(), data)
                routerData?.let {
                    repository.updatePayload(it.payload)
                }
            }
        }
    }
}