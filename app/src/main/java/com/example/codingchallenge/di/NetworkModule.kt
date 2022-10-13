package com.example.codingchallenge.di

import com.example.codingchallenge.BuildConfig
import com.example.codingchallenge.data.AnimeAPI
import com.example.codingchallenge.data.AuthorsAPI
import com.example.codingchallenge.data.MoviesAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun providesOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .writeTimeout(10L, TimeUnit.SECONDS)
        .readTimeout(10L, TimeUnit.SECONDS)
        .addInterceptor(
            HttpLoggingInterceptor().apply {
                if (BuildConfig.DEBUG) {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            }
        )
        .build()

    @Provides
    @Singleton
    @Named("Authors")
    fun providesRetrofitAuthor(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BuildConfig.API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    @Named("Anime")
    fun providesRetrofitAnime(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BuildConfig.API_URL_ANIME)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    @Named("Movies")
    fun providesRetrofitMovies(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BuildConfig.API_URL_MOVIES)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providesAnimeAPI(@Named("Anime") retrofit: Retrofit): AnimeAPI =
        retrofit.create(AnimeAPI::class.java)

    @Provides
    @Singleton
    fun providesAuthorsAPI(@Named("Authors") retrofit: Retrofit): AuthorsAPI =
        retrofit.create(AuthorsAPI::class.java)

    @Provides
    @Singleton
    fun providesMoviesAPI(@Named("Movies") retrofit: Retrofit): MoviesAPI =
        retrofit.create(MoviesAPI::class.java)
}