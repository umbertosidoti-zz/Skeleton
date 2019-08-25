package com.umbo.skeleton.di

import androidx.lifecycle.ViewModel
import com.umbo.data.NetworkRepo
import com.umbo.data_android.ImageLoader
import com.umbo.di.ViewModelKey
import com.umbo.di.scope.FragmentScope
import com.umbo.domain.ListInteractor
import com.umbo.domain.ListInteractorImpl
import com.umbo.domain.PhotosStorage
import com.umbo.skeleton.list.ListRecylerViewAdapter
import com.umbo.skeleton.list.ListViewModel
import com.umbo.skeleton.list.PostToViewStateMapper
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module(includes = [ListFragmentModule.Bind::class])
class ListFragmentModule {

    @Provides
    @FragmentScope
    fun provideListInteractor(networkRepo: NetworkRepo, storage: PhotosStorage)
            : ListInteractor = ListInteractorImpl(networkRepo, storage)

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