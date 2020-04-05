package com.umbo.skeleton.di

import androidx.lifecycle.ViewModel
import com.umbo.data.ImageLoader
import com.umbo.di.ViewModelKey
import com.umbo.di.scope.FragmentScope
import com.umbo.data.ListInteractor
import com.umbo.domain.interactor.ListInteractorImpl
import com.umbo.data.PhotosRepository
import com.umbo.presentation.list.ListRecylerViewAdapter
import com.umbo.presentation.list.ListViewModel
import com.umbo.presentation.list.PostToViewStateMapper
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module(includes = [ListFragmentModule.Bind::class])
class ListFragmentModule {

    @Provides
    @FragmentScope
    fun provideListInteractor(repository: PhotosRepository)
            : ListInteractor =
        ListInteractorImpl(repository)

    @Provides
    fun providePostToViewStateMapper() = PostToViewStateMapper()

    @Provides
    fun provideListRecylerViewAdapter(imageLoader: ImageLoader) = ListRecylerViewAdapter(imageLoader)

    @Module
    interface Bind {
        @Binds
        @IntoMap
        @ViewModelKey(ListViewModel::class)
        fun bindListViewModel(viewModel: ListViewModel): ViewModel
    }
}