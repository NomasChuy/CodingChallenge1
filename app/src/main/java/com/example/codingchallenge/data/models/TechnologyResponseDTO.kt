package com.example.codingchallenge.data.models

import com.google.gson.annotations.SerializedName

data class TechnologyResponseDTO(
    @SerializedName("results")
    val results: List<TechnologyResponseDTOItem>,
)

