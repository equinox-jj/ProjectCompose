package com.projectcompose.data.mapper

import com.projectcompose.data.source.remote.model.CharacterResponse
import com.projectcompose.data.source.remote.model.ResultsItem
import com.projectcompose.domain.model.CharacterData
import com.projectcompose.domain.model.CharacterResults

fun CharacterResponse.responseToDomain(): CharacterData {
    return CharacterData(
        results = results.map { it.resultsToDomain() }
    )
}

fun ResultsItem.resultsToDomain(): CharacterResults {
    return CharacterResults(
        image = image,
        gender = gender,
        species = species,
        name = name,
    )
}