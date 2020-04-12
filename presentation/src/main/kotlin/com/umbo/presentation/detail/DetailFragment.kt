package com.umbo.presentation.detail

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import com.umbo.data.Outcome
import com.umbo.data.ImageLoader
import com.umbo.di.ViewModelProvidersWrapper
import com.umbo.presentation.core.BaseFragment
import kotlinx.android.synthetic.main.detail_fragment.*
import kotlinx.android.synthetic.main.list_fragment.*

import javax.inject.Inject

class DetailFragment : BaseFragment() {

    override val layoutId: Int = com.umbo.presentation.R.layout.detail_fragment

    @Inject
    lateinit var imageLoader: ImageLoader

    @Inject
    lateinit var viewModelProvider: ViewModelProvidersWrapper

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val viewModel = viewModelProvider.of(this).get(DetailViewModel::class.java)
        viewModel.liveData.observe(viewLifecycleOwner, Observer { outcome ->
            when(outcome) {
                is Outcome.Success -> handleSuccess(outcome.value)
                is Outcome.Error -> handleError()
            }
        })
    }

    private fun handleError() {
        detailContainer.visibility = View.GONE
        detailLoading.visibility = View.GONE
        detailError.visibility = View.VISIBLE
    }

    private fun handleSuccess(viewState: DetailViewState) {
        detailContainer.visibility = View.VISIBLE
        detailError.visibility = View.GONE
        detailLoading.visibility = View.GONE
        imageLoader.load(viewState.url, detailImage)
        detailDescription.text = viewState.title
        detailUrl.text = viewState.url
        detailSize.text = viewState.size
    }
}
