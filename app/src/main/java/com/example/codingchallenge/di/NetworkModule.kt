package com.example.codingchallenge.di

import com.example.codingchallenge.BuildConfig
import com.example.codingchallenge.data.AnimeAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
     @Singleton
     @Provides
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
     fun providesRetrofitInstance(okHttpClient: OkHttpClient): Retrofit{
          return Retrofit.Builder()
               .client(okHttpClient)
               .baseUrl(BuildConfig.API_URL)
               .addConverterFactory(GsonConverterFactory.create())
               .build()
     }

     @Provides
     @Singleton
     fun providesLaunchAPI(retrofit: Retrofit): AnimeAPI =
          retrofit.create(AnimeAPI::class.java)
}