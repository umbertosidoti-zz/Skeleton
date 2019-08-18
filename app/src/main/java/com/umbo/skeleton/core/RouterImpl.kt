package com.umbo.skeleton.core

import android.os.Bundle
import androidx.navigation.NavController
import com.umbo.data.Destination
import com.umbo.data.NavigationCommand
import com.umbo.skeleton.R
import com.umbo.skeleton.core.Router.Companion.PAYLOAD_KEY

class RouterImpl : Router {
    override fun routeTo(action: NavigationCommand) {
        val bundle = Bundle()
        action.payload?.let {
            bundle.putSerializable(PAYLOAD_KEY, it)
        }
        when (action.destination) {
            Destination.DETAIL -> navController?.navigate(R.id.action_listFragment_to_detailFragment, bundle)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController?.navigateUp() ?: false
    }

    private var navController: NavController? = null

    override fun setNavController(navController: NavController) {
        this.navController = navController
    }

    override fun getNavController(): NavController? {
        return navController
    }
}