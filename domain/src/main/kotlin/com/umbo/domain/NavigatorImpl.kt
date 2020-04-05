package com.umbo.domain

import com.umbo.data.NavigationCommand
import com.umbo.data.Navigator

class NavigatorImpl: Navigator {

    override var listener: ((action: NavigationCommand)->(Unit))? = null

    override fun routeTo(action: NavigationCommand) {
        listener?.invoke(action)
    }
}