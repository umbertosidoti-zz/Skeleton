package com.umbo.skeleton.di

import androidx.lifecycle.ViewModel
import com.umbo.di.ViewModelKey
import com.umbo.di.scope.FragmentScope
import com.umbo.domain.interactor.DetailInteractor
import com.umbo.domain.interactor.DetailInteractorImpl
import com.umbo.domain.repository.PhotosRepository
import com.umbo.skeleton.detail.DetailViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module(includes = [DetailFragmentModule.Bind::class])
class DetailFragmentModule {

    @Provides
    @FragmentScope
    fun provideDetailInteractor(photosRepository: PhotosRepository): DetailInteractor =
        DetailInteractorImpl(photosRepository)

    @Module
    interface Bind {
        @Binds
        @IntoMap
        @ViewModelKey(DetailViewModel::class)
        fun bindListViewModel(viewModel: DetailViewModel): ViewModel
    }
}