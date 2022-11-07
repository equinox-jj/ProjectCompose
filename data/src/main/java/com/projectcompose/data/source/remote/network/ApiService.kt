package com.projectcompose.data.source.remote.network

import com.projectcompose.data.source.remote.model.CharacterResponse
import com.projectcompose.data.source.remote.model.ResultsItem
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("character")
    suspend fun getAllCharacters(): CharacterResponse

    @GET("character/{id}")
    suspend fun getCharacterById(
        @Path("id") id: Int,
    ): ResultsItem

}