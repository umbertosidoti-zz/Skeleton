package com.umbo.skeleton.di

import androidx.lifecycle.ViewModel
import com.umbo.domain.ListInteractor
import com.umbo.domain.ListInteractorImpl
import com.umbo.skeleton.list.ListViewModel
import com.umbo.skeleton.list.ListViewState
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module(includes = [ListFragmentModule.Bind::class])
class ListFragmentModule {

    @Provides
    fun provideListInteractor(): ListInteractor = ListInteractorImpl()

    @Module
    interface Bind {
        @Binds
        @IntoMap
        @ViewModelKey(ListViewModel::class)
        fun bindListViewModel(viewModel: ListViewModel): ViewModel
    }
}