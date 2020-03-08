package com.umbo.skeleton.di.test

import com.umbo.skeleton.SkeletonApp
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class TestApp: SkeletonApp() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerTestSkeletonComponent.builder()
            .application(this)
            .build()
    }
}