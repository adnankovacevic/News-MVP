package com.example.newsapii.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapii.R
import com.example.newsapii.model.Article
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.news_row.view.*

class NewsAdapter(var news:List<Article>,private val listener:(Int) -> Unit): RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val cell = LayoutInflater.from(parent.context).inflate(R.layout.news_row,parent,false)
        return NewsViewHolder(cell)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(news[position],listener)
    }

    override fun getItemCount(): Int {
        return news.size
    }

    class NewsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(news: Article, listener: (Int) -> Unit){

            itemView.article_title_feed.text = news.title
            itemView.article_date_feed.text = news.publishedAt
            Picasso.get().load(news.urlToImage).into(itemView.article_image_feed)
            itemView.setOnClickListener { listener(adapterPosition) }
        }
    }
}