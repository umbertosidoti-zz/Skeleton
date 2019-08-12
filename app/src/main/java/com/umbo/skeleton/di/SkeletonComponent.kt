package com.umbo.skeleton.di

import android.app.Application
import com.umbo.di.network.RetrofitModule
import com.umbo.di.ViewModelFactoryModule
import com.umbo.di.image.GlideModule
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
        SkeletonModule::class,
        RetrofitModule::class,
        GlideModule::class,
        ActivitiesModule::class,
        ViewModelFactoryModule::class
    ]
)
interface SkeletonComponent: AndroidInjector<SkeletonApp> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): SkeletonComponent
    }

    override fun inject(app: SkeletonApp)
}
