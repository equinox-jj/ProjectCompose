package com.projectcompose.domain.usecase

import com.projectcompose.domain.model.CharacterResults
import com.projectcompose.domain.repository.Repository
import com.projectcompose.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CharacterInteractor @Inject constructor(private val repository: Repository) : CharacterUseCase {
    override fun getAllCharacters(): Flow<Resource<List<CharacterResults>>> = repository.getAllCharacters()
    override fun getCharacterById(id: Int): Flow<Resource<CharacterResults>> = repository.getCharacterById(id)
}