package com.umbo.presentation.detail

import com.umbo.data.DetailInteractor
import com.umbo.data.Outcome
import com.umbo.data.corutines.IO
import com.umbo.presentation.core.BaseViewModelLiveData
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class DetailViewModel @Inject constructor(@IO private val dispatcher: CoroutineDispatcher, private val interactor: DetailInteractor) :
    BaseViewModelLiveData<Outcome<DetailViewState>>(dispatcher) {

    var payload: Int? = null

    override fun start() {
        doAsync {
            payload?.let {
                when (val outcome = interactor.findPhoto(it)) {
                    is Outcome.Success -> mutableLiveData.postValue(
                        Outcome.Success(
                            DetailViewState(
                                outcome.value.title,
                                outcome.value.url,
                                outcome.value.albumId.toString()
                            )
                        )
                    )
                    is Outcome.Error -> mutableLiveData.postValue(Outcome.Error())
                }
            } ?: mutableLiveData.postValue(Outcome.Error())
        }
    }
}
