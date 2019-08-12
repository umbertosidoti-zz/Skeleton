package com.umbo.skeleton.di

import com.umbo.di.ProviderFactoryWrapper
import com.umbo.di.scope.ActivityScope
import com.umbo.skeleton.core.Router
import com.umbo.skeleton.core.RouterImpl
import dagger.Module
import dagger.Provides

@Module(includes = [
    ProviderFactoryWrapper::class,
    FragmentsModule::class])
class MainActivityModule {

    @ActivityScope
    @Provides
    fun provideRouter(): Router = RouterImpl()

}
