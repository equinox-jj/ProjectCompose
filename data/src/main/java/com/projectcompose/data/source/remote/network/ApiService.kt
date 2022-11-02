package com.projectcompose.data.source.remote.network

import com.projectcompose.data.source.remote.model.CharacterResponse
import retrofit2.http.GET

interface ApiService {

    @GET("character")
    suspend fun getAllCharacters(): CharacterResponse

}