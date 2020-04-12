package com.umbo.skeleton

import android.os.Bundle
import android.os.PersistableBundle
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.umbo.skeleton.instancestate.InstanceStateHandler
import com.umbo.data.Router
import com.umbo.di.ViewModelProvidersWrapper
import com.umbo.presentation.core.NavigationViewModel
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var instanceStateHandler: InstanceStateHandler

    @Inject
    lateinit var viewModelProvider: ViewModelProvidersWrapper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setNavigationController()

        savedInstanceState?.let {
            instanceStateHandler.onRestoreInstanceState(it)
        }

        val navigationViewModel = viewModelProvider.of(this).get(NavigationViewModel::class.java)
        navigationViewModel.liveData.observe(this, Observer {
            router.routeTo(it)
        })
    }

    private fun setNavigationController() {
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        router.setNavController(navController)
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return router.onSupportNavigateUp()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        instanceStateHandler.onSaveInstanceState(outState)
        super.onSaveInstanceState(outState)
    }
}
