package com.example.codingchallenge.data

import com.example.codingchallenge.data.models.TechnologyResponseDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AuthorsAPI {
    @GET("quotes")
    suspend fun fetchTechnology(@Query("query") technology: String = "technology"): Response<TechnologyResponseDTO>
}