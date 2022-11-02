package com.projectcompose.domain.usecase

import com.projectcompose.domain.model.CharacterResults
import com.projectcompose.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface CharacterUseCase {
    fun getAllCharacters(): Flow<Resource<List<CharacterResults>>>
}