package com.umbo.skeleton.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.umbo.skeleton.R
import com.umbo.di.ViewModelProvidersWrapper
import dagger.android.support.DaggerFragment
import javax.inject.Inject


class ListFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelWrapper: ViewModelProvidersWrapper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val viewModel = viewModelWrapper.of(this).get(ListViewModel::class.java)
        viewModel.liveData.observe(viewLifecycleOwner,  Observer { state ->
        })
    }
}
