package com.umbo.skeleton.detail

import com.umbo.data.Outcome
import com.umbo.data.Photo
import com.umbo.domain.DetailInteractor
import com.umbo.skeleton.core.BaseViewModelLiveData
import com.umbo.skeleton.core.ViewStateOutcome
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailViewModel @Inject constructor(private val interactor: DetailInteractor) :
    BaseViewModelLiveData<ViewStateOutcome<DetailViewState>>() {

    var payload: Int? = null

    override fun start() {
        CoroutineScope(Dispatchers.IO).launch {
            payload?.let {
                when (val outcome = interactor.findPhoto(it)) {
                    is Outcome.Success -> liveData.postValue(
                        ViewStateOutcome.Success(
                            DetailViewState(
                                outcome.value.title,
                                outcome.value.url,
                                outcome.value.albumId.toString()
                            )
                        )
                    )
                    is Outcome.Error -> liveData.postValue(ViewStateOutcome.Error("error"))
                }
            }
        }
    }
}
