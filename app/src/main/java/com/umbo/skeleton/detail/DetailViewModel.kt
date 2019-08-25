package com.umbo.skeleton.detail

import com.umbo.domain.DetailInteractor
import com.umbo.skeleton.core.BaseViewModelLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailViewModel @Inject constructor(private val interactor: DetailInteractor) : BaseViewModelLiveData<DetailViewState>() {

    var payload: Int? = null

    override fun start() {
        CoroutineScope(Dispatchers.IO).launch {
            payload?.let {
                val photo = interactor.findPhoto(it)
                photo?.let {storedPhoto ->
                    liveData.postValue(DetailViewState(storedPhoto.title, storedPhoto.url, storedPhoto.albumId.toString()))
                }
            }
        }
    }
}
