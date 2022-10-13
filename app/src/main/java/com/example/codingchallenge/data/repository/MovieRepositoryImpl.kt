package com.example.codingchallenge.data.repository

import com.example.codingchallenge.data.MoviesAPI
import com.example.codingchallenge.data.toDomainQuote
import com.example.codingchallenge.domain.Quote
import com.example.codingchallenge.domain.repository.QuotesRepository
import com.example.codingchallenge.utils.Resource
import java.io.IOException
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val moviesAPI: MoviesAPI) : QuotesRepository{
    override suspend fun fetchQuote(): Resource<ArrayList<Quote>> {
        return try {
            val response = moviesAPI.fetchMovies("20", "tag", "movies")
            if(response.isSuccessful){
                val body = response.body()
                val list = body?.movieResponseDTOItems?.map { it.toDomainQuote() } ?: emptyList()
                val result = arrayListOf<Quote>()
                result.addAll(list)
                return Resource.Success(result)
            }
            else
                Resource.Failure("Error.")
        }catch (e:IOException){
            Resource.Failure("Couldn't reach server. Check your internet connection.", e)
        }catch (e: Exception){
            Resource.Failure("An unexpected error ocurred.",e)
        }
    }

}