package com.example.codingchallenge.data.models

import com.google.gson.annotations.SerializedName

data class TechnologyResponseDTOItem(
    @SerializedName("_id")
    val _id: String,
    @SerializedName("author")
    val author: String,
    @SerializedName("authorId")
    val authorId: String,
    @SerializedName("authorSlug")
    val authorSlug: String,
    @SerializedName("content")
    val content: String,
    @SerializedName("dateAdded")
    val dateAdded: String,
    @SerializedName("dateModified")
    val dateModified: String,
    @SerializedName("length")
    val length: Int,
    @SerializedName("tags")
    val tags: List<String>
)
