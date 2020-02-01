package com.umbo.skeleton.list

import com.umbo.data.Destination
import com.umbo.data.NavigationCommand
import com.umbo.data.Outcome
import com.umbo.data.Photo
import com.umbo.domain.ListInteractor
import com.umbo.skeleton.core.BaseViewModelLiveData
import com.umbo.skeleton.core.ViewStateOutcome
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ListViewModel @Inject constructor(
    private val interactor: ListInteractor,
    private val postToViewStateMapper: PostToViewStateMapper): BaseViewModelLiveData<ViewStateOutcome<List<PhotoViewState>>>() {

    override fun start() {
        CoroutineScope(Dispatchers.IO).launch {
            interactor.clearData()

            val viewState = when (val result = interactor.photos()){
                is Outcome.Success -> ViewStateOutcome.Success(result.value.map { postToViewStateMapper.map(it) })
                is Outcome.Error -> ViewStateOutcome.Error("error")
            }

            liveData.postValue(viewState)
        }
    }

    fun onItemClick(id: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            val photoId = (interactor.photos() as? Outcome.Success)?.value?.find { it.id == id}
            if(photoId != null) {
                navigationAction.postValue(NavigationCommand(Destination.DETAIL, id))
            } else {
                ViewStateOutcome.Error("error")
            }
        }
    }
}
