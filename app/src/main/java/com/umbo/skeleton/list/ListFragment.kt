package com.umbo.skeleton.list

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.umbo.skeleton.R
import com.umbo.skeleton.core.BaseFragment
import com.umbo.skeleton.core.HasRouter
import kotlinx.android.synthetic.main.list_fragment.*
import javax.inject.Inject


class ListFragment : BaseFragment() {

    override val layoutId: Int = R.layout.list_fragment

    @Inject
    lateinit var adapter: ListRecylerViewAdapter


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        listRecyclerView.layoutManager = LinearLayoutManager(context)
        listRecyclerView.adapter = adapter

        val viewModel = viewModelProvider.of(this).get(ListViewModel::class.java)

        adapter.onItemClick = {
            viewModel.onItemClick(it)
        }

        viewModel.liveData.observe(viewLifecycleOwner, Observer { state ->
            if (!state.error) {
                adapter.addPhotos(state.photos)
            }
        })

        viewModel.navigationAction.observe(viewLifecycleOwner, Observer { action ->
            action?.let {
                (activity as? HasRouter)?.router?.routeTo(action)
            }
        })
    }
}
