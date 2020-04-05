package com.umbo.skeleton.di

import androidx.lifecycle.ViewModel
import com.umbo.data.NavigationPayloadRepository
import com.umbo.data.Navigator
import com.umbo.di.ProviderFactoryWrapper
import com.umbo.di.scope.ActivityScope
import com.umbo.data.PhotosStorage
import com.umbo.data.Router
import com.umbo.di.ViewModelKey
import com.umbo.domain.NavigatorImpl
import com.umbo.domain.PhotosStorageImpl
import com.umbo.domain.repository.NavigationPayloadRepositoryImpl
import com.umbo.presentation.core.NavigationViewModel
import com.umbo.presentation.detail.DetailViewModel
import com.umbo.skeleton.routing.RouterImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module(includes = [
    MainActivityModule.Bind::class,
    ProviderFactoryWrapper::class,
    FragmentsModule::class])
class MainActivityModule {

    @ActivityScope
    @Provides
    fun providePhotoStorage(): PhotosStorage = PhotosStorageImpl()

    @ActivityScope
    @Provides
    fun provideNavigationPayloadRepository() : NavigationPayloadRepository = NavigationPayloadRepositoryImpl()

    @ActivityScope
    @Provides
    fun provideRouter(navigationPayloadRepository: NavigationPayloadRepository): Router = RouterImpl(navigationPayloadRepository)


    @ActivityScope
    @Provides
    fun provideNavigator(): Navigator = NavigatorImpl()

    @Module
    interface Bind {
        @Binds
        @IntoMap
        @ViewModelKey(NavigationViewModel::class)
        fun bindListViewModel(viewModel: NavigationViewModel): ViewModel
    }
}
