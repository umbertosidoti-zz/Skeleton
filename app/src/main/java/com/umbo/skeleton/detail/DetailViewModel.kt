package com.umbo.skeleton.detail

import androidx.lifecycle.viewModelScope
import com.umbo.data.Outcome
import com.umbo.domain.DetailInteractor
import com.umbo.skeleton.core.BaseViewModelLiveData
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class DetailViewModel @Inject constructor(private val context: CoroutineContext, private val interactor: DetailInteractor) :
    BaseViewModelLiveData<Outcome<DetailViewState>>() {

    var payload: Int? = null

    override fun start() {
        viewModelScope.launch(context) {
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
