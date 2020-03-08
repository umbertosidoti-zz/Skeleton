package com.umbo.skeleton

import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.umbo.skeleton.core.HasRouter
import com.umbo.skeleton.core.Router
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(), HasRouter {

    @Inject
    override lateinit var router: Router

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setNavigationController()
    }

    private fun setNavigationController() {
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        router.setNavController(navController)
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return router.onSupportNavigateUp()
    }
}
