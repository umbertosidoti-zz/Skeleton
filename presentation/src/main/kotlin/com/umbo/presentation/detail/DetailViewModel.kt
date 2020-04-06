package com.umbo.presentation.detail

import com.umbo.data.DetailInteractor
import com.umbo.data.Navigator
import com.umbo.data.Outcome
import com.umbo.data.corutines.IO
import com.umbo.presentation.core.BaseViewModelLiveData
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class DetailViewModel @Inject constructor(
    @IO dispatcher: CoroutineDispatcher,
    navigator: Navigator,
    private val interactor: DetailInteractor
) : BaseViewModelLiveData<Outcome<DetailViewState>>(dispatcher, navigator) {

    override fun onStartObserve() {
        doAsync {
            when (val outcome = interactor.findPhoto()) {
                is Outcome.Success -> postValue(
                    Outcome.Success(
                        DetailViewState(
                            outcome.value.title,
                            outcome.value.url,
                            outcome.value.albumId.toString()
                        )
                    )
                )
                is Outcome.Error -> postValue(Outcome.Error())
            }
        }
    }
}
