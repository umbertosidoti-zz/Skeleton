package com.umbo.skeleton.detail

import androidx.lifecycle.viewModelScope
import com.umbo.data.Outcome
import com.umbo.domain.interactor.DetailInteractor
import com.umbo.skeleton.core.BaseViewModelLiveData
import com.umbo.skeleton.di.corutines.IO
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailViewModel @Inject constructor(@IO private val dispatcher: CoroutineDispatcher, private val interactor: DetailInteractor) :
    BaseViewModelLiveData<Outcome<DetailViewState>>() {

    var payload: Int? = null

    override fun start() {
        viewModelScope.launch(dispatcher) {
            payload?.let {
                when (val outcome = interactor.findPhoto(it)) {
                    is Outcome.Success -> liveData.postValue(
                        Outcome.Success(
                            DetailViewState(
                                outcome.value.title,
                                outcome.value.url,
                                outcome.value.albumId.toString()
                            )
                        )
                    )
                    is Outcome.Error -> liveData.postValue(Outcome.Error())
                }
            } ?: liveData.postValue(Outcome.Error())
        }
    }
}
