package com.umbo.skeleton.detail

import com.umbo.domain.DetailInteractor
import com.umbo.skeleton.core.BaseViewModelLiveData
import javax.inject.Inject

class DetailViewModel @Inject constructor(private val interactor: DetailInteractor) : BaseViewModelLiveData<DetailViewState>() {

    var payload: Int? = null

    override fun start() {

    }
}
