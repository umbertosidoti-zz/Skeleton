package com.umbo.skeleton.di

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner
import com.umbo.skeleton.di.test.TestApp


internal class MockTestRunner : AndroidJUnitRunner() {
    @Throws(InstantiationException::class, IllegalAccessException::class, ClassNotFoundException::class)

    override fun newApplication(
        cl: ClassLoader, className: String, context: Context
    ): Application {
        return super.newApplication(
            cl, TestApp::class.java.name, context
        )
    }
}