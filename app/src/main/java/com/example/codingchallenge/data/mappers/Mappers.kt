package com.example.codingchallenge.data

import com.example.codingchallenge.data.models.AnimeCharacterResponseDTOItem
import com.example.codingchallenge.data.models.MovieResponseDTOItem
import com.example.codingchallenge.data.models.TechnologyResponseDTOItem
import com.example.codingchallenge.domain.Quote

fun TechnologyResponseDTOItem.toDomainQuote() : Quote{
    return Quote(
        name = this.author,
        quote = this.content,
        extraData = this.dateAdded
    )
}

fun AnimeCharacterResponseDTOItem.toDomainQuote() : Quote{
    return Quote(
        name = this.anime,
        quote = this.quote,
        extraData = this.character
    )
}

fun MovieResponseDTOItem.toDomainQuote() : Quote{
    return Quote(
        name = this.author,
        quote = this.text,
        extraData = this.tag
    )
}

