package com.umbo.skeleton.instancestate

import android.os.Bundle
import android.os.PersistableBundle

interface InstanceStateHandler {
    fun onSaveInstanceState(outState: Bundle)
    fun onRestoreInstanceState(savedInstanceState: Bundle?)
}