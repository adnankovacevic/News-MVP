package com.example.newsapii

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapii.adapter.NewsAdapter
import com.example.newsapii.model.Article
import com.example.newsapii.ui.NewsFeedPresenter
import com.example.newsapii.ui.NewsFeedView
import com.example.newsapii.ui.NewsInteractor
import com.example.newsapii.util.RVItemDecoration
import com.example.newsapii.util.showToast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), NewsFeedView {

    private lateinit var presenter: NewsFeedPresenter
    private lateinit var adapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        presenter = NewsFeedPresenter(this, NewsInteractor())

        newsRV.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
            addItemDecoration(RVItemDecoration(2, RecyclerView.VERTICAL))
        }
        adapter = NewsAdapter(listOf()) {
            presenter.onItemClick(it)
        }
        newsRV.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        presenter.getNews()
    }

    override fun presentNews(news: List<Article>) {
        runOnUiThread {
            adapter.news = news
            adapter.notifyDataSetChanged()
        }

    }

    override fun presentFail(errorMessage: String) {
        showToast(this, errorMessage)
    }

    override fun onItemClick(adapterPosition: Int) {
        showToast(this, "You clicked $adapterPosition")
    }


}