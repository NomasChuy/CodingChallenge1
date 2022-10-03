package com.example.codingchallenge.domain.repository

import com.example.codingchallenge.domain.AnimeCharacter
import com.example.codingchallenge.utils.Resource

interface AnimeRepository {
    suspend fun fetchAnimes(): Resource<ArrayList<AnimeCharacter>>
}