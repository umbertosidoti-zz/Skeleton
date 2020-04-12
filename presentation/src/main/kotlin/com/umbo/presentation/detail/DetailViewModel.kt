package com.umbo.presentation.detail

import android.util.Log
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
        Log.e("UMBO", "Find photo")
        doAsync {
            when (val outcome = interactor.findPhoto()) {
                is Outcome.Success -> postValue(
                    Outcome.Success(
                        DetailViewState(
                            outcome.value.description ?: "empty",
                            outcome.value.url,
                            "${outcome.value.width} x ${outcome.value.height}"
                        )
                    )
                )
                is Outcome.Error -> postValue(Outcome.Error())
            }
        }
    }
}
