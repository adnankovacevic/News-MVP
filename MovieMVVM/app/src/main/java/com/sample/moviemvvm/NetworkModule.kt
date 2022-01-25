package com.sample.moviemvvm

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideBaseURL(): String = "https://jsonplaceholder.typicode.com/"

    @Provides
    fun provideRetrofit(url: String): Retrofit =
        Retrofit.Builder().baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create()).build()

    @Provides
    fun providePostAPI(retrofit: Retrofit): PostApi =
        retrofit.create(PostApi::class.java)
}