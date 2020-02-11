package com.umbo.skeleton

import androidx.test.InstrumentationRegistry
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.runner.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule



@RunWith(AndroidJUnit4ClassRunner::class)
class ExampleInstrumentedTest {


    @Test
    fun testNavigateSecondScreen() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("com.umbo.skeleton", appContext.packageName)
    }

}
