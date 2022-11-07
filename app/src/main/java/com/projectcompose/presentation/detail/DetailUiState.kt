package com.projectcompose.presentation.detail

import com.projectcompose.domain.model.CharacterResults

data class DetailUiState(
    val isLoading: Boolean = false,
    val isError: String? = null,
    val data: CharacterResults? = null,
)
