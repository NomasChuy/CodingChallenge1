package com.example.codingchallenge.data

import com.example.codingchallenge.data.models.MovieResponseDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesAPI {
    @GET("random/{id}")
    suspend fun fetchMovies(
        @Path("id") id : String ,
        @Query("type") tag: String ,
        @Query("val") value: String
    ): Response<MovieResponseDTO>
}
