package com.example.codingchallenge.data.repository

import com.example.codingchallenge.data.AuthorsAPI
import com.example.codingchallenge.data.toDomainQuote
import com.example.codingchallenge.domain.Quote
import com.example.codingchallenge.domain.repository.QuotesRepository
import com.example.codingchallenge.utils.Resource
import java.io.IOException
import javax.inject.Inject

class AuthorRepositoryImpl @Inject constructor(private val authorsAPI: AuthorsAPI):  QuotesRepository{
    override suspend fun fetchQuote(): Resource<ArrayList<Quote>> {
        return try {
            val response = authorsAPI.fetchTechnology()
            if(response.isSuccessful){
                val body = response.body()
                val list = body?.results?.map { it.toDomainQuote() } ?: emptyList()
                val result = arrayListOf<Quote>()
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