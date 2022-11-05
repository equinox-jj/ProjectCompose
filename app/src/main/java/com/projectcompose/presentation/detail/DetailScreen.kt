package com.projectcompose.presentation.detail

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign

@Composable
fun DetailScreen() {
    Surface() {
        Text(
            text = "This is detail screen",
            modifier = Modifier.fillMaxSize(),
            textAlign = TextAlign.Center,
        )
    }
}