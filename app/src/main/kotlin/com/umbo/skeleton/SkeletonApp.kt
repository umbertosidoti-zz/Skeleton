package com.umbo.skeleton

import com.umbo.skeleton.di.DaggerSkeletonComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

open class SkeletonApp : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {

        return DaggerSkeletonComponent.builder()
            .application(this)
            .build()
    }

    override fun onCreate() {
        super.onCreate()
    }
}
