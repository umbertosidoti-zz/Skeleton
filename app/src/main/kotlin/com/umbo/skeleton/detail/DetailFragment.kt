package com.umbo.skeleton.detail

import android.os.Bundle
import androidx.lifecycle.Observer
import com.umbo.data.Outcome
import com.umbo.data_android.ImageLoader
import com.umbo.skeleton.R
import com.umbo.skeleton.core.BaseFragment
import kotlinx.android.synthetic.main.detail_fragment.*
import javax.inject.Inject

class DetailFragment : BaseFragment() {
    override val layoutId: Int = R.layout.detail_fragment

    @Inject
    lateinit var imageLoader: ImageLoader

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val viewModel = viewModelProvider.of(this).get(DetailViewModel::class.java)
        viewModel.payload = payload as? Int
        viewModel.liveData.observe(viewLifecycleOwner, Observer { outcome ->

            when(outcome) {
                is Outcome.Success -> handleSuccess(outcome.value)
                is Outcome.Error -> handleError()
            }

        })
    }

    private fun handleError() {

    }

    private fun handleSuccess(viewState: DetailViewState) {
        imageLoader.load(viewState.url, detailImage)
        detailTitle.text = viewState.title
        detailUrl.text = viewState.url
        detailAlbum.text = viewState.album
    }
}
