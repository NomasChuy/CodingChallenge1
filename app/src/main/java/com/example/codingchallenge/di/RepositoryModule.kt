package com.example.codingchallenge.di
import com.example.codingchallenge.data.repository.AnimeRepositoryImpl
import com.example.codingchallenge.data.repository.AuthorRepositoryImpl
import com.example.codingchallenge.domain.repository.AnimeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn (SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindAnimeRepository(implementation : AnimeRepositoryImpl) : AnimeRepository
}