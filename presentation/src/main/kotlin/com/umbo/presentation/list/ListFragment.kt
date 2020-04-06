package com.umbo.presentation.list


import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.umbo.data.Outcome
import com.umbo.di.ViewModelProvidersWrapper
import com.umbo.presentation.core.BaseFragment
import kotlinx.android.synthetic.main.list_fragment.*
import javax.inject.Inject


class ListFragment : BaseFragment() {

    override val layoutId: Int = com.umbo.presentation.R.layout.list_fragment

    @Inject
    lateinit var adapter: ListRecylerViewAdapter

    @Inject
    lateinit var viewModelProvider: ViewModelProvidersWrapper

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        listRecyclerView.layoutManager = LinearLayoutManager(context)
        listRecyclerView.adapter = adapter

        val viewModel = viewModelProvider.of(this).get(ListViewModel::class.java)

        adapter.onItemClick = {
            viewModel.onItemClick(it)
        }

        viewModel.liveData.observe(viewLifecycleOwner, Observer { outcome ->
            when(outcome) {
                is Outcome.Success -> handleSuccessState(outcome.value)
                is Outcome.Error -> handleError()
            }
        })
    }

    private fun handleError() {
        listLoading.visibility = View.GONE
        listError.visibility = View.VISIBLE
    }

    private fun handleSuccessState(photos: List<PhotoViewState>) {
        listLoading.visibility = View.GONE
        listError.visibility = View.GONE
        adapter.addPhotos(photos)
    }
}
