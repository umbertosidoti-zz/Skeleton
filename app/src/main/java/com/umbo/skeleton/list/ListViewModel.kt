package com.umbo.skeleton.list

import androidx.lifecycle.viewModelScope
import com.umbo.data.Destination
import com.umbo.data.NavigationCommand
import com.umbo.data.Outcome
import com.umbo.domain.ListInteractor
import com.umbo.skeleton.core.BaseViewModelLiveData
import com.umbo.skeleton.di.corutines.IO
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

class ListViewModel @Inject constructor(@IO private val dispatcher: CoroutineDispatcher,
                                        private val interactor: ListInteractor,
                                        private val postToViewStateMapper: PostToViewStateMapper
) : BaseViewModelLiveData<Outcome<List<PhotoViewState>>>() {

    override fun start() {
        viewModelScope.launch(dispatcher) {
            val viewState = when (val result = interactor.photos()) {
                is Outcome.Success -> Outcome.Success(result.value.map { postToViewStateMapper.map(it) })
                is Outcome.Error -> Outcome.Error()
            }

            liveData.postValue(viewState)
        }
    }

    fun onItemClick(id: Int) {
        viewModelScope.launch(dispatcher) {
            val photoId = (interactor.photos() as? Outcome.Success)?.value?.find { it.id == id }
            if (photoId != null) {
                navigationAction.postValue(NavigationCommand(Destination.DETAIL, id))
            } else {
                liveData.postValue(Outcome.Error())
            }
        }
    }
}
