package com.projectcompose.data.repository

import com.projectcompose.data.mapper.resultsToDomain
import com.projectcompose.data.source.remote.network.ApiService
import com.projectcompose.domain.model.CharacterResults
import com.projectcompose.domain.repository.Repository
import com.projectcompose.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: ApiService) : Repository {
    override fun getAllCharacters(): Flow<Resource<List<CharacterResults>>> = flow {
        emit(Resource.Loading())
        try {
            val results = apiService.getAllCharacters().results.map { it.resultsToDomain() }
            emit(Resource.Success(results))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: ""))
        }
    }
}