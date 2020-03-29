package com.umbo.data

import androidx.navigation.NavController

interface Router {

    companion object {
        val PAYLOAD_KEY = "payload"
    }

    fun onSupportNavigateUp(): Boolean
    fun setNavController(navController: NavController)
    fun getNavController(): NavController?
    fun routeTo(action: NavigationCommand)
}