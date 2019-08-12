package com.umbo.skeleton.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.umbo.di.ViewModelProvidersWrapper
import com.umbo.skeleton.R
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.list_fragment.*
import javax.inject.Inject


class ListFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelWrapper: ViewModelProvidersWrapper

    @Inject
    lateinit var adapter: ListRecylerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        listRecyclerView.layoutManager = LinearLayoutManager(context)
        listRecyclerView.adapter = adapter

        val viewModel = viewModelWrapper.of(this).get(ListViewModel::class.java)
        viewModel.liveData.observe(viewLifecycleOwner,  Observer { state ->
            if(!state.error){
                adapter.addPhotos(state.photos)
            }
        })
    }
}
