package com.umbo.skeleton.instancestate

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import com.umbo.data.NavigationPayload
import com.umbo.data.NavigationPayloadRepository
import kotlinx.serialization.*
import kotlinx.serialization.json.Json

@Serializable
data class PayloadWrapper(val payload: NavigationPayload)

class InstanceStateHandlerImpl(private val json: Json, private val repository: NavigationPayloadRepository) : InstanceStateHandler {

    private val ROUTER_DATA: String = "routerData"

    override fun onSaveInstanceState(outState: Bundle) {
        val serialized = json.stringify(PayloadWrapper.serializer(), PayloadWrapper(repository.payload))
        outState.putString(ROUTER_DATA, serialized)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        savedInstanceState?.let { bundle ->
            val stringData =  bundle.getString(ROUTER_DATA)
            stringData?.let { data ->
                val routerData: PayloadWrapper? = json.parse(PayloadWrapper.serializer(), data)
                routerData?.let {
                    repository.updatePayload(it.payload)
                }
            }
        }
    }
}