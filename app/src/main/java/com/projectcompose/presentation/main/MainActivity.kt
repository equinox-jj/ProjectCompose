package com.projectcompose.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.projectcompose.presentation.detail.DetailScreen
import com.projectcompose.presentation.home.HomeScreen
import com.projectcompose.presentation.navigation.AppNavigation
import com.projectcompose.ui.theme.ProjectComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalMaterial3Api
@ExperimentalFoundationApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainApp()
        }
    }
}

@ExperimentalMaterial3Api
@ExperimentalFoundationApi
@Composable
fun MainApp() {
    ProjectComposeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = AppNavigation.Home.route,
            ) {
                composable(route = AppNavigation.Home.route) {
                    HomeScreen(navController = navController)
                }
                composable(route = AppNavigation.Detail.route) {
                    DetailScreen()
                }
            }
        }
    }
}