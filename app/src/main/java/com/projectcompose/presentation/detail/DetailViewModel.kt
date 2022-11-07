package com.projectcompose.presentation.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.projectcompose.domain.usecase.CharacterUseCase
import com.projectcompose.domain.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val characterUseCase: CharacterUseCase,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val charId: Int = checkNotNull(savedStateHandle["id"])

    private val _stateFlow = MutableStateFlow(DetailUiState())
    val stateFlow = _stateFlow.asStateFlow()

    init {
//        savedStateHandle.get<Int>("id")?.let { id ->
//            getCharacterById(charId)
//        }
        getCharacterById(charId)
    }

    private fun getCharacterById(id: Int) {
        characterUseCase.getCharacterById(id).onEach { response ->
            when (response) {
                is Resource.Loading -> {
                    _stateFlow.update { newState ->
                        newState.copy(
                            isLoading = true,
                            isError = null,
                            data = null
                        )
                    }
                }
                is Resource.Success -> {
                    _stateFlow.update { newState ->
                        newState.copy(
                            isLoading = false,
                            isError = null,
                            data = response.data
                        )
                    }
                }
                is Resource.Error -> {
                    _stateFlow.update { newState ->
                        newState.copy(
                            isLoading = false,
                            isError = response.message,
                            data = null
                        )
                    }
                }
            }
        }.launchIn(viewModelScope)
    }

}