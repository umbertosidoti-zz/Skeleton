package com.umbo.data

import androidx.navigation.NavController

interface Router {
    fun onSupportNavigateUp(): Boolean
    fun setNavController(navController: NavController)
    fun getNavController(): NavController?
    fun routeTo(action: NavigationCommand)
}