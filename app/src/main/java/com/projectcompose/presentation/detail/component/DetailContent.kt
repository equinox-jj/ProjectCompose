package com.projectcompose.presentation.detail.component

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.projectcompose.presentation.detail.DetailViewModel

@Composable
fun DetailContent(
    viewModel: DetailViewModel = hiltViewModel(),
    padding: PaddingValues,
) {
    val state = viewModel.stateFlow.collectAsState().value
    Box(modifier = Modifier.fillMaxSize()) {
        Log.d("characterId", state.data?.id.toString())
        Text(
            modifier = Modifier.fillMaxSize(),
            text = state.data?.id.toString(),
        )
    }
}