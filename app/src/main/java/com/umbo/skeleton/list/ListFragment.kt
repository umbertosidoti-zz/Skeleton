package com.umbo.skeleton.list

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.umbo.skeleton.R
import com.umbo.skeleton.di.ViewModelProvidersFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject


class ListFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvidersFactory

    @Inject
    lateinit var viewState: ListViewState

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val viewModel = viewModelFactory.of(this).get(ListViewModel::class.java)
        viewModel.liveData.observe(viewLifecycleOwner,  Observer { state ->

        })
    }
}
