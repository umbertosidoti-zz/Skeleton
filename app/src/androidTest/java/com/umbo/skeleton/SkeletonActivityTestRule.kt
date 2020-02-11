package com.umbo.skeleton

import android.app.Activity
import androidx.test.espresso.IdlingRegistry
import androidx.test.rule.ActivityTestRule
import com.umbo.skeleton.di.test.EspressoIdlingResource

class SkeletonActivityTestRule<T : Activity>(
    activityClass: Class<T>,
    initialTouchMode: Boolean = false,
    launchActivity:Boolean = true)
    : ActivityTestRule<T>(activityClass, initialTouchMode, launchActivity) {

    override fun beforeActivityLaunched() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getIdlingResource())
        super.beforeActivityLaunched()

    }

    override fun afterActivityFinished() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getIdlingResource())
        super.afterActivityFinished()
    }
}