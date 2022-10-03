package com.example.codingchallenge.data.models

import com.google.gson.annotations.SerializedName

data class AnimeCharacterResponseDTOItem(
    @SerializedName("anime")
    val anime: String,
    @SerializedName("character")
    val character: String,
    @SerializedName("quote")
    val quote: String
)