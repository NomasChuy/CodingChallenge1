package com.example.codingchallenge.data.models

import com.google.gson.annotations.SerializedName

data class MovieResponseDTO(
    @SerializedName("count")
    val count: Int,
    @SerializedName("message")
    val message: String,
    @SerializedName("quotes")
    val movieResponseDTOItems: List<MovieResponseDTOItem>,
    @SerializedName("status")
    val status: Int
)
