package com.projectcompose.domain.repository

import com.projectcompose.domain.model.CharacterResults
import com.projectcompose.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface Repository {
    fun getAllCharacters(): Flow<Resource<List<CharacterResults>>>
}