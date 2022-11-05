package com.projectcompose.presentation.navigation

sealed class AppNavigation(val route: String) {
    object Home : AppNavigation(route = "home")
    object Detail : AppNavigation(route = "detail")
}