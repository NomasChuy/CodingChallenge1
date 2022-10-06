package com.example.codingchallenge.data.repository

import com.example.codingchallenge.data.AuthorsAPI
import com.example.codingchallenge.data.toDomainCharacter
import com.example.codingchallenge.domain.AnimeCharacter
import com.example.codingchallenge.domain.repository.AnimeRepository
import com.example.codingchallenge.utils.Resource
import java.io.IOException
import javax.inject.Inject

class AuthorRepositoryImpl @Inject constructor(private val authorsAPI: AuthorsAPI):  AnimeRepository{
    override suspend fun fetchAnimes(): Resource<ArrayList<AnimeCharacter>> {
        return try {
            val response = authorsAPI.fetchTechnology()
            if(response.isSuccessful){
                val body = response.body()
                val list = body?.results?.map { it.toDomainCharacter() } ?: emptyList()
                val result = arrayListOf<AnimeCharacter>()
                result.addAll(list)
                return Resource.Success(result)
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