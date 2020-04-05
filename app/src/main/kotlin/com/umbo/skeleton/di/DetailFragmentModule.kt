package com.umbo.skeleton.di

import androidx.lifecycle.ViewModel
import com.umbo.data.DetailInteractor
import com.umbo.data.NavigationPayloadRepository
import com.umbo.di.ViewModelKey
import com.umbo.di.scope.FragmentScope
import com.umbo.domain.interactor.DetailInteractorImpl
import com.umbo.data.PhotosRepository
import com.umbo.presentation.detail.DetailViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module(includes = [DetailFragmentModule.Bind::class])
class DetailFragmentModule {

    @Provides
    @FragmentScope
    fun provideDetailInteractor(
        photosRepository: PhotosRepository,
        navigationPayloadRepository: NavigationPayloadRepository
    ): DetailInteractor =
        DetailInteractorImpl(photosRepository, navigationPayloadRepository)

    @Module
    interface Bind {
        @Binds
        @IntoMap
        @ViewModelKey(DetailViewModel::class)
        fun bindListViewModel(viewModel: DetailViewModel): ViewModel
    }
}