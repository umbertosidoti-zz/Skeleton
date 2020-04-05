package com.umbo.presentation.list


import com.umbo.data.*
import com.umbo.data.corutines.IO
import com.umbo.presentation.core.BaseViewModelLiveData
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class ListViewModel @Inject constructor(
    @IO private val dispatcher: CoroutineDispatcher,
    private val interactor: ListInteractor,
    private val postToViewStateMapper: PostToViewStateMapper
) : BaseViewModelLiveData<Outcome<List<PhotoViewState>>>(dispatcher) {

    override fun start() {
        doAsync {
            val viewState = when (val result = interactor.photos()) {
                is Outcome.Success -> Outcome.Success(result.value.map {
                    postToViewStateMapper.map(
                        it
                    )
                })
                is Outcome.Error -> Outcome.Error()
            }

            mutableLiveData.postValue(viewState)
        }
    }

    fun onItemClick(id: Int) {
        doAsync {
            (interactor.navigationPayload(id) as? Outcome.Success)?.value?.let {
                navigationAction.postValue(
                    NavigationCommand(
                        Destination.DETAIL,
                        it
                    )
                )
            } ?: mutableLiveData.postValue(Outcome.Error())
        }
    }
}
