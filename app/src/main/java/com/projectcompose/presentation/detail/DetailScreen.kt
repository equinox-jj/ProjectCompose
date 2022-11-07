package com.projectcompose.presentation.detail

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import com.projectcompose.presentation.detail.component.DetailContent

@ExperimentalMaterial3Api
@Composable
fun DetailScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "DetailScreen") },
            )
        },
        content = { padding ->
            DetailContent(padding = padding)
        }
    )
}