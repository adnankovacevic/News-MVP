package com.example.newsapii.network

import com.example.newsapii.model.NewsResponse
import com.example.newsapii.util.Constants.apiKey
import com.example.newsapii.util.Constants.country
import com.example.newsapii.util.Constants.pageSize
import com.example.newsapii.util.Constants.topHeadlines
import retrofit2.Call
import retrofit2.http.GET

interface NewsService {

    @GET("$topHeadlines$country=us&$pageSize=100&$apiKey")
    fun getTopHeadlines(): Call<NewsResponse>
}