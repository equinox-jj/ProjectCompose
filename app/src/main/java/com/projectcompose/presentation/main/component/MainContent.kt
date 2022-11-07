package com.projectcompose.presentation.main.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.projectcompose.presentation.detail.DetailScreen
import com.projectcompose.presentation.home.HomeScreen
import com.projectcompose.presentation.navigation.AppNavigation
import com.projectcompose.ui.theme.ProjectComposeTheme

@ExperimentalMaterial3Api
@ExperimentalFoundationApi
@Composable
fun MainContent() {
    ProjectComposeTheme {
        val navController = rememberNavController()
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            NavHost(
                navController = navController,
                startDestination = AppNavigation.Home.route,
            ) {
                composable(route = AppNavigation.Home.route) {
                    HomeScreen(navController = navController)
                }
                composable(
                    route = AppNavigation.Detail.route + "/{id}",
                    arguments = listOf(navArgument("id") { type = NavType.IntType })) {
                    DetailScreen()
                }
            }
        }
    }
}