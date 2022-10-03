package com.example.codingchallenge.data.repository

import com.example.codingchallenge.data.AnimeAPI
import com.example.codingchallenge.data.models.AnimeCharacterResponseDTO
import com.example.codingchallenge.data.toDomain
import com.example.codingchallenge.domain.AnimeCharacter
import com.example.codingchallenge.domain.repository.AnimeRepository
import com.example.codingchallenge.utils.Resource
import java.io.IOException
import javax.inject.Inject

class AnimeRepositoryImpl @Inject constructor(
    private val animeAPI: AnimeAPI
) : AnimeRepository{

    override suspend fun fetchAnimes(): Resource<ArrayList<AnimeCharacter>> {
        return try {
            val response = animeAPI.fetchAnime()
            if(response.isSuccessful){
                val body: AnimeCharacterResponseDTO = response.body()?: AnimeCharacterResponseDTO()
                return Resource.Success(body.toDomain())
            }else {
                return Resource.Failure("An unexpected error ocurred.",null)
            }
        }catch (e: IOException){
            Resource.Failure("Couldn't reach server. Check your internet connection.", e)
        }catch (e: Exception){
            Resource.Failure("An unexpected error ocurred.",e)
        }
    }
}
