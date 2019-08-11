package com.umbo.skeleton.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.umbo.skeleton.list.ListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(ListViewModel::class)
    fun bindWeatherViewModel(weatherViewModel: ListViewModel): ViewModel
}
