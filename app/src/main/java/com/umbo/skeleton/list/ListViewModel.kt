package com.umbo.skeleton.list

import com.umbo.data.Destination
import com.umbo.data.NavigationCommand
import com.umbo.data.Outcome
import com.umbo.domain.ListInteractor
import com.umbo.skeleton.core.BaseViewModelLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ListViewModel @Inject constructor(private val scope: CoroutineScope,
                                        private val interactor: ListInteractor,
    private val postToViewStateMapper: PostToViewStateMapper
) : BaseViewModelLiveData<Outcome<List<PhotoViewState>>>() {

    override fun start() {
        scope.launch {
            val viewState = when (val result = interactor.photos()) {
                is Outcome.Success -> Outcome.Success(result.value.map { postToViewStateMapper.map(it) })
                is Outcome.Error -> Outcome.Error()
            }

            liveData.postValue(viewState)
        }
    }

    fun onItemClick(id: Int) {
        scope.launch {
            val photoId = (interactor.photos() as? Outcome.Success)?.value?.find { it.id == id }
            if (photoId != null) {
                navigationAction.postValue(NavigationCommand(Destination.DETAIL, id))
            } else {
                Outcome.Error()
            }
        }
    }
}
