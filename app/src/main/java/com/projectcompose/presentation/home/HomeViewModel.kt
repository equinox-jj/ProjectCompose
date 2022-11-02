package com.projectcompose.presentation.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.projectcompose.domain.usecase.CharacterUseCase
import com.projectcompose.domain.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val characterUseCase: CharacterUseCase,
) : ViewModel() {

    var state by mutableStateOf(HomeUiState())
        private set

    private val _stateFlow = MutableStateFlow(HomeUiState())
    val stateFlow = _stateFlow.asStateFlow()

    init {
        getAllCharacters()
    }

    private fun getAllCharacters() {
        characterUseCase.getAllCharacters().onEach { response ->
            when (response) {
                is Resource.Loading -> {
                    _stateFlow.update { newState ->
                        newState.copy(
                            isLoading = true,
                            isError = null,
                            data = emptyList()
                        )
                    }
                }
                is Resource.Success -> {
                    _stateFlow.update { newState ->
                        newState.copy(
                            isLoading = false,
                            isError = null,
                            data = response.data ?: emptyList()
                        )
                    }
                }
                is Resource.Error -> {
                    _stateFlow.update { newState ->
                        newState.copy(
                            isLoading = false,
                            isError = response.message,
                            data = emptyList()
                        )
                    }
                }
            }
        }.launchIn(viewModelScope)
    }

}