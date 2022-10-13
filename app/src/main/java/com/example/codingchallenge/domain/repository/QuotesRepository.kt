package com.example.codingchallenge.domain.repository

import com.example.codingchallenge.domain.Quote
import com.example.codingchallenge.utils.Resource

interface QuotesRepository {
    suspend fun fetchQuote(): Resource<ArrayList<Quote>>
}