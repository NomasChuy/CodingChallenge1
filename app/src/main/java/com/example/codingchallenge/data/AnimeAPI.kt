package com.example.codingchallenge.data
import com.example.codingchallenge.data.models.AnimeCharacterResponseDTO
import com.example.codingchallenge.data.models.AnimeCharacterResponseDTOItem
import retrofit2.Response
import retrofit2.http.GET


interface AnimeAPI {
    @GET("quotes")
    suspend fun fetchAnime() : Response<AnimeCharacterResponseDTO>
}
//AnimeCharacterResponseDTO