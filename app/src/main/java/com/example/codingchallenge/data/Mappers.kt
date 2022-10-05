package com.example.codingchallenge.data

import com.example.codingchallenge.data.models.TechnologyResponseDTO
import com.example.codingchallenge.data.models.TechnologyResponseDTOItem
import com.example.codingchallenge.domain.AnimeCharacter

fun TechnologyResponseDTOItem.toDomain() : AnimeCharacter{
    return AnimeCharacter(animeName = author, characterName = content, characterQuote = dateAdded )
}

fun TechnologyResponseDTO.toDomain() : List<AnimeCharacter>{
    return (this.results.map {  technologyResponseDTO ->
        technologyResponseDTO.toDomain()
    })
}
/*

fun TechnologyResponseDTOItem.toDomain() : AnimeCharacter{
    return AnimeCharacter(animeName = author, characterName = content, characterQuote = dateAdded )
}

fun ArrayList<AnimeCharacterResponseDTOItem>.toDomain() : ArrayList<AnimeCharacter> =
    (this.map { animeDTO ->
        animeDTO.toDomain()
    }) as ArrayList<AnimeCharacter>

fun AnimeCharacterResponseDTO.toDomain() : ArrayList<AnimeCharacter>{
    return (this.map {  animeCharacterResponseDTOItem ->
        animeCharacterResponseDTOItem.toDomain()
    }) as ArrayList<AnimeCharacter>
}*/
