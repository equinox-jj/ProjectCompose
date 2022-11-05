package com.projectcompose.presentation.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.projectcompose.presentation.component.CharacterCard
import com.projectcompose.presentation.component.RickTopBar
import com.projectcompose.presentation.navigation.AppNavigation

@ExperimentalMaterial3Api
@ExperimentalFoundationApi
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    navController: NavController,
) {
    val state = viewModel.stateFlow.collectAsState().value
    Scaffold(
        topBar = {
            RickTopBar()
        },
        content = { padding ->
            Box(modifier = Modifier.fillMaxSize()) {
                if (state.isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                if (state.data.isNotEmpty()) {
                    LazyVerticalStaggeredGrid(
                        columns = StaggeredGridCells.Fixed(2),
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = padding
                    ) {
                        state.data.size.let { total ->
                            items(total) { i ->
                                val data = state.data[i]
                                CharacterCard(
                                    data = data,
                                    onClick = {
                                        navController.navigate(AppNavigation.Detail.route)
                                    }
                                )
                            }
                        }
                    }
                }
                if (state.isError?.isNotEmpty() == true) {
                    Text(
                        text = state.isError,
                        style = MaterialTheme.typography.titleLarge,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.Center),
                    )
                }
            }
        },
    )
}