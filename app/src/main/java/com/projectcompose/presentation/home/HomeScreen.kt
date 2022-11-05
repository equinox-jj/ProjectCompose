package com.projectcompose.presentation.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.projectcompose.presentation.component.RickTopBar
import com.projectcompose.presentation.home.component.HomeContent

@ExperimentalMaterial3Api
@ExperimentalFoundationApi
@Composable
fun HomeScreen(
    navController: NavController,
) {
    Scaffold(
        topBar = {
            RickTopBar()
        },
        content = { padding ->
            HomeContent(
                padding = padding,
                navController = navController,
            )
        },
    )
}