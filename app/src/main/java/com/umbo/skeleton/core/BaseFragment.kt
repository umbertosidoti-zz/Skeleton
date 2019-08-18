package com.umbo.skeleton.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import com.umbo.di.ViewModelProvidersWrapper
import dagger.android.support.DaggerFragment
import java.io.Serializable
import javax.inject.Inject


abstract class BaseFragment: DaggerFragment() {

    abstract val layoutId: Int

    @Inject
    lateinit var viewModelProvider: ViewModelProvidersWrapper

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