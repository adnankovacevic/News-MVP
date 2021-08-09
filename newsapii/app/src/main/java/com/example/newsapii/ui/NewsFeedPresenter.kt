package com.example.newsapii.ui

import com.example.newsapii.model.Article


class NewsFeedPresenter(private var newsView: NewsFeedView?, private val newsInteractor: NewsInteractor) :
        NewsInteractor.OnFinishedListener {

    fun getNews() {
        newsInteractor.requestData(this)
    }

    fun onDestroy() {
        newsView = null
    }

    fun onItemClick(adapterPosition: Int) {
        newsView?.onItemClick(adapterPosition)
    }

    override fun onSuccess(results: List<Article>) {
        newsView?.presentNews(results)
    }

    override fun onError(errorMessage: String) {
        newsView?.presentFail(errorMessage)
    }


}