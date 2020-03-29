package com.umbo.skeleton.di.test

import android.app.Application
import com.umbo.skeleton.di.RetrofitModule
import com.umbo.di.ViewModelFactoryModule
import com.umbo.skeleton.di.GlideModule
import com.umbo.skeleton.di.ActivitiesModule
import com.umbo.skeleton.di.SkeletonModule
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
        TestCoroutinesModule::class,
        RetrofitModule::class,
        GlideModule::class,
        ActivitiesModule::class,
        ViewModelFactoryModule::class
    ]
)
interface TestSkeletonComponent: AndroidInjector<TestApp> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): TestSkeletonComponent
    }

    override fun inject(app: TestApp)
}
