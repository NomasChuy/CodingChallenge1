package com.example.codingchallenge.data.models

import com.google.gson.annotations.SerializedName

data class TechnologyResponseDTOItem(
    @SerializedName("author")
    val author: String,
    @SerializedName("content")
    val content: String,
    @SerializedName("dateAdded")
    val dateAdded: String,
)