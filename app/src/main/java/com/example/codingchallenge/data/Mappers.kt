package com.example.codingchallenge.data

import com.example.codingchallenge.data.models.AnimeCharacterResponseDTO
import com.example.codingchallenge.data.models.AnimeCharacterResponseDTOItem
import com.example.codingchallenge.domain.AnimeCharacter

fun AnimeCharacterResponseDTOItem.toDomain() : AnimeCharacter{
    return AnimeCharacter(this.anime,this.character,this.quote)
}

fun ArrayList<AnimeCharacterResponseDTOItem>.toDomain() : ArrayList<AnimeCharacter> =
    (this.map { animeDTO ->
        animeDTO.toDomain()
    }) as ArrayList<AnimeCharacter>

fun AnimeCharacterResponseDTO.toDomain() : ArrayList<AnimeCharacter>{
    return (this.map {  animeCharacterResponseDTOItem ->
        animeCharacterResponseDTOItem.toDomain()
    }) as ArrayList<AnimeCharacter>
}