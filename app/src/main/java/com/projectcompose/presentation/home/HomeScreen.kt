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
import com.projectcompose.presentation.component.CharacterCard

@ExperimentalMaterial3Api
@ExperimentalFoundationApi
@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {

    val state = viewModel.stateFlow.collectAsState().value

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "HomeScreen")
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant,
                    titleContentColor = MaterialTheme.colorScheme.onSurfaceVariant
                )
            )
        },
        content = { values ->
            Box(modifier = Modifier.fillMaxSize()) {

                LazyVerticalStaggeredGrid(
                    columns = StaggeredGridCells.Fixed(2),
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = values
                ) {
                    state.data.size.let { total ->
                        items(total) { i ->
                            val data = state.data[i]
                            CharacterCard(data = data) {}
                        }
                    }
                }

                if (state.isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }

                if (state.isError?.isNotBlank() == true) {
                    Text(
                        text = state.isError,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.Center)
                    )
                }

            }
        },
        bottomBar = {
            BottomAppBar {

            }
        }
    )

}