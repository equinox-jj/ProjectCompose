package com.projectcompose.presentation.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.projectcompose.presentation.detail.DetailScreen
import com.projectcompose.presentation.home.HomeScreen

interface AppNavigation {
    val icon: ImageVector
    val route: String
    val screen: @Composable () -> Unit
}

@ExperimentalFoundationApi
@ExperimentalMaterial3Api
object Home : AppNavigation {
    override val icon: ImageVector = Icons.Filled.Home
    override val route: String = "home"
    override val screen: @Composable () -> Unit = { HomeScreen() }
}

object Detail : AppNavigation {
    override val icon: ImageVector = Icons.Filled.Person
    override val route: String = "detail"
    override val screen: @Composable () -> Unit = { DetailScreen() }
}