package com.example.codingchallenge.di

import javax.inject.Qualifier

@Qualifier
@Retention (AnnotationRetention.BINARY)
annotation class AnimesRepository

@Qualifier
@Retention (AnnotationRetention.BINARY)
annotation class AuthorsRepository

@Qualifier
@Retention (AnnotationRetention.BINARY)
annotation class MoviesRepository