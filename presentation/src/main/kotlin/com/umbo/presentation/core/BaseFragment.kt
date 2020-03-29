package com.umbo.presentation.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.umbo.data.Router
import dagger.android.support.DaggerFragment
import java.io.Serializable

abstract class BaseFragment: DaggerFragment() {

    abstract val layoutId: Int

    var payload: Serializable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle = this.arguments
        if (bundle != null) {
            payload = bundle.getSerializable(Router.PAYLOAD_KEY)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutId, container, false)
    }
}