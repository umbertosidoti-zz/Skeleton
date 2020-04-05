package com.umbo.presentation.list


import androidx.lifecycle.viewModelScope
import com.umbo.data.Destination
import com.umbo.data.NavigationCommand
import com.umbo.data.Outcome
import com.umbo.data.ListInteractor
import com.umbo.data.corutines.IO
import com.umbo.presentation.core.BaseViewModelLiveData
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

class ListViewModel @Inject constructor(@IO private val dispatcher: CoroutineDispatcher,
                                        private val interactor: ListInteractor,
                                        private val postToViewStateMapper: PostToViewStateMapper
) : BaseViewModelLiveData<Outcome<List<PhotoViewState>>>(dispatcher) {

    override fun start() {
        doAsync {
            val viewState = when (val result = interactor.photos()) {
                is Outcome.Success -> Outcome.Success(result.value.map { postToViewStateMapper.map(it) })
                is Outcome.Error -> Outcome.Error()
            }

            liveData.postValue(viewState)
        }
    }

    fun onItemClick(id: Int) {
        doAsync {
            val photoId = (interactor.photos() as? Outcome.Success)?.value?.find { it.id == id }
            if (photoId != null) {
                navigationAction.postValue(NavigationCommand(Destination.DETAIL, id))
            } else {
                liveData.postValue(Outcome.Error())
            }
        }
    }
}
