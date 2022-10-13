package com.example.codingchallenge.data.models

import com.google.gson.annotations.SerializedName

data class MovieResponseDTOItem(
    @SerializedName("author")
    val author: String,
    @SerializedName("tag")
    val tag: String,
    @SerializedName("text")
    val text: String
)