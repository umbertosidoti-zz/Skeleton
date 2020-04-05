package com.umbo.skeleton.routing

import androidx.navigation.NavController
import com.umbo.data.Destination
import com.umbo.data.NavigationCommand
import com.umbo.data.NavigationPayloadRepository
import com.umbo.data.Router
import com.umbo.skeleton.R

class RouterImpl(private val repository: NavigationPayloadRepository) : Router {
    override fun routeTo(action: NavigationCommand) {

        action.payload?.let {
            repository.updatePayload(it)
        }

        when (action.destination) {
            Destination.DETAIL -> navController?.navigate(R.id.action_listFragment_to_detailFragment)
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