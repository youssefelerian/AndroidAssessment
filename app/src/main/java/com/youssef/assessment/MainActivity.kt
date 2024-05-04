package com.youssef.assessment

import android.os.Bundle
import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.fragment.NavHostFragment
import com.youssef.assessment.databinding.ActivityMainBinding
import dagger.android.support.DaggerAppCompatActivity


/**
 * Created by Youssef Ebrahim Elerian on 3/5/24.
 * youssef.elerian@gmail.com
 */

class MainActivity : DaggerAppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setupGraph()
        val request = NavDeepLinkRequest.Builder
            .fromUri("android-app://assessment.youssef.app/details".toUri())
            .build()
        navController.navigate(request)
    }

    private fun setupGraph() {
        val navHost =
            supportFragmentManager.findFragmentById(R.id.navigationHost) as NavHostFragment
        navController = navHost.navController
        val inflater = navController.navInflater
        val graph = inflater.inflate(R.navigation.main_graph)
        navController.setGraph(graph, null)
    }
}
