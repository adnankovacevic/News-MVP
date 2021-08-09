package com.example.newsapii.ui

import com.example.newsapii.model.Article

interface NewsFeedView {
    fun presentNews(news: List<Article>)
    fun presentFail(errorMessage: String)
    fun onItemClick(adapterPosition: Int)
}