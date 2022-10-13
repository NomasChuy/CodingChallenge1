package com.example.codingchallenge.di
import com.example.codingchallenge.data.repository.AnimeRepositoryImpl
import com.example.codingchallenge.data.repository.AuthorRepositoryImpl
import com.example.codingchallenge.data.repository.MovieRepositoryImpl
import com.example.codingchallenge.domain.repository.QuotesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn (SingletonComponent::class)
abstract class RepositoryModule {
    @MoviesRepository
    @Binds
    abstract fun bindRepository(implementation : MovieRepositoryImpl) : QuotesRepository

    @AuthorsRepository
    @Binds
    abstract fun bindRepository2(implementation : AuthorRepositoryImpl) : QuotesRepository

    @AnimesRepository
    @Binds
    abstract fun bindRepository3(implementation : AnimeRepositoryImpl) : QuotesRepository
}