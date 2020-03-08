package com.umbo.skeleton.core

import androidx.navigation.NavController
import com.umbo.data.NavigationCommand

interface Router {

    companion object {
        val PAYLOAD_KEY = "payload"
    }

    fun onSupportNavigateUp(): Boolean
    fun setNavController(navController: NavController)
    fun getNavController(): NavController?
    fun routeTo(action: NavigationCommand)
}