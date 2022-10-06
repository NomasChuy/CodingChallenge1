package com.example.codingchallenge.data

import com.example.codingchallenge.data.models.AnimeCharacterResponseDTOItem
import com.example.codingchallenge.data.models.TechnologyResponseDTOItem
import com.example.codingchallenge.domain.AnimeCharacter

fun TechnologyResponseDTOItem.toDomainCharacter() : AnimeCharacter{
    return AnimeCharacter(
        animeName = this.author,
        characterQuote = this.content,
        characterName = this.dateAdded
    )
}

fun AnimeCharacterResponseDTOItem.toDomainCharacter() : AnimeCharacter{
    return AnimeCharacter(
        animeName = this.anime,
        characterQuote = this.quote,
        characterName = this.character
    )
}

