package com.sample.moviemvvm

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.sample.moviemvvm.databinding.ActivityDetailsBinding

class PostAdapter(val posts: List<Post>) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder =
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.activity_details, parent, false
        )


    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        //holder.binding.post = posts[position]
        holder.bind(posts[position])
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    class PostViewHolder(val binding: ActivityDetailsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(post: Post) {
            binding.title.text = post.title
            binding.description.text = post.body
        }
    }

    private val diffCallback = object : DiffUtil.ItemCallback<Post>() {
        override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem == newItem
        }
    }
    private val differ = AsyncListDiffer(this, diffCallback)

    fun submitList(list: List<Post>) {
        differ.submitList(list)
    }
}