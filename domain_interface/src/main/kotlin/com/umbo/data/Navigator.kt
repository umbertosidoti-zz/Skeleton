package com.umbo.data

interface Navigator {
    var listener: ((action: NavigationCommand)->(Unit))?
    fun routeTo(action: NavigationCommand)
}