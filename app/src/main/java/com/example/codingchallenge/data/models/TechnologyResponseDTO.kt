package com.example.codingchallenge.data.models

import com.google.gson.annotations.SerializedName

data class TechnologyResponseDTO(
    @SerializedName("count")
    val count: Int,
    @SerializedName("lastItemIndex")
    val lastItemIndex: Int,
    @SerializedName("page")
    val page: Int,
    @SerializedName("totalCount")
    val totalCount: Int,
    @SerializedName("totalPages")
    val totalPages: Int,
    @SerializedName("results")
    val results: List<TechnologyResponseDTOItem>
)

