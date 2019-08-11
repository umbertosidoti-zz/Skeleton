package com.umbo.skeleton.list

import com.umbo.domain.ListInteractor
import com.umbo.skeleton.core.BaseViewModelLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ListViewModel @Inject constructor(private val interactor: ListInteractor): BaseViewModelLiveData<ListViewState>() {
    // TODO: Implement the ViewModel

    override fun start() {

        CoroutineScope(Dispatchers.IO).launch {
            val result = interactor.posts()
            liveData.postValue(ListViewState("test"))
        }

    }
}
