package com.projectcompose.presentation.home

import com.projectcompose.domain.model.CharacterResults

data class HomeUiState(
    val isLoading: Boolean = false,
    val isError: String? = null,
    val data: List<CharacterResults> = emptyList()
)
