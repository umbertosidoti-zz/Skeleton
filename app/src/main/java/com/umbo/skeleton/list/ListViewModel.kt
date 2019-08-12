package com.umbo.skeleton.list

import com.umbo.domain.ListInteractor
import com.umbo.skeleton.core.BaseViewModelLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ListViewModel @Inject constructor(
    private val interactor: ListInteractor,
    private val postToViewStateMapper: PostToViewStateMapper): BaseViewModelLiveData<ListViewState>() {

    override fun start() {
        CoroutineScope(Dispatchers.IO).launch {
            val result = interactor.photos()?.map { postToViewStateMapper.map(it) }
            val viewState = if(result != null) {
                ListViewState(false, result)
            } else {
                ListViewState(true, emptyList())
            }
            liveData.postValue(viewState)
        }
    }
}
