package com.umbo.skeleton.di

import com.umbo.di.ProviderFactoryWrapper
import dagger.Module

@Module(includes = [
    ProviderFactoryWrapper::class,
    FragmentsModule::class])
class MainActivityModule {

}
