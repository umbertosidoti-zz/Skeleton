package com.umbo.skeleton.core

import androidx.navigation.NavController

interface Router {
    fun routeToDetail(id: Int)
    fun onSupportNavigateUp(): Boolean
    fun setNavController(navController: NavController)
    fun getNavController(): NavController?
}