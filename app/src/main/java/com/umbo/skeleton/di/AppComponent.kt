package com.umbo.skeleton.di

import android.app.Application
import com.umbo.skeleton.SkeletonApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityBuilder::class,
        ViewModelModule::class
    ]
)
interface AppComponent: AndroidInjector<SkeletonApp> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

    override fun inject(app: SkeletonApp)
}
