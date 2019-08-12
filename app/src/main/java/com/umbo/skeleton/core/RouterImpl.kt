package com.umbo.skeleton.core

import androidx.navigation.NavController
import com.umbo.skeleton.R

class RouterImpl(): Router {

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

    override fun routeToDetail(id: Int) {
        navController?.navigate(R.id.action_listFragment_to_detailFragment)
    }
}