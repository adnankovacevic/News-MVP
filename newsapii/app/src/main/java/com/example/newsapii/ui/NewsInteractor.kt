package com.example.newsapii.ui

import com.example.newsapii.model.Article
import com.example.newsapii.model.NewsResponse
import com.example.newsapii.network.NewsService
import com.example.newsapii.network.ServiceBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsInteractor {

    interface OnFinishedListener {
        fun onSuccess(results: List<Article>)
        fun onError(errorMessage: String)
    }

    fun requestData(onFinishedListener: OnFinishedListener) {

        val newsService = ServiceBuilder.buildService(NewsService::class.java)
        val callRequest = newsService.getTopHeadlines()

        callRequest.enqueue(object : Callback<NewsResponse> {
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                //val response: MutableList<Article>? = mutableListOf()

                if (response.isSuccessful) {
                    onFinishedListener.onSuccess(response.body()!!.articles)
                } else {
                    onFinishedListener.onError("Nothing to show")
                }
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                onFinishedListener.onError("----------Something went wrong----------")
            }

        })

    }
}