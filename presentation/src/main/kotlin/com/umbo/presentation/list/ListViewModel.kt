package com.umbo.presentation.list


import com.umbo.data.*
import com.umbo.data.corutines.IO
import com.umbo.presentation.core.BaseViewModelLiveData
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class ListViewModel @Inject constructor(
    @IO dispatcher: CoroutineDispatcher,
    navigator: Navigator,
    private val interactor: ListInteractor,
    private val postToViewStateMapper: PostToViewStateMapper
) : BaseViewModelLiveData<Outcome<List<PhotoViewState>>>(dispatcher, navigator) {

    override fun onStart() {
        doAsync {
            val viewState = when (val result = interactor.photos()) {
                is Outcome.Success -> Outcome.Success(result.value.map {
                    postToViewStateMapper.map(
                        it
                    )
                })
                is Outcome.Error -> Outcome.Error()
            }

            postValue(viewState)
        }
    }

    fun onItemClick(id: Int) {
        doAsync {
            (interactor.navigationPayload(id) as? Outcome.Success)?.value?.let {
                routeTo(NavigationCommand(
                    Destination.DETAIL,
                    it
                ))
            } ?: postValue(Outcome.Error())
        }
    }
}
