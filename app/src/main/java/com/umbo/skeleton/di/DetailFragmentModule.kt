package com.umbo.skeleton.di

import androidx.lifecycle.ViewModel
import com.umbo.data.NetworkRepo
import com.umbo.data_android.ImageLoader
import com.umbo.di.ViewModelKey
import com.umbo.di.scope.FragmentScope
import com.umbo.domain.DetailInteractor
import com.umbo.domain.DetailInteractorImpl
import com.umbo.domain.ListInteractor
import com.umbo.domain.ListInteractorImpl
import com.umbo.skeleton.detail.DetailViewModel
import com.umbo.skeleton.list.ListRecylerViewAdapter
import com.umbo.skeleton.list.ListViewModel
import com.umbo.skeleton.list.PostToViewStateMapper
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module(includes = [DetailFragmentModule.Bind::class])
class DetailFragmentModule {

    @Provides
    @FragmentScope
    fun provideDetailInteractor(): DetailInteractor = DetailInteractorImpl()

    @Module
    interface Bind {
        @Binds
        @IntoMap
        @ViewModelKey(DetailViewModel::class)
        fun bindListViewModel(viewModel: DetailViewModel): ViewModel
    }
}