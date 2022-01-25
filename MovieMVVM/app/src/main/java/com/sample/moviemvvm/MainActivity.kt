package com.sample.moviemvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.sample.moviemvvm.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var adapter: PostAdapter
    private lateinit var binding: ActivityMainBinding
    private lateinit var posts:List<Post>
    private val viewModel: PostViewModel by viewModels()
    private val tag =  "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
       /* val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)*/

        uiSetup()
        vmSetup()
    }

    private fun uiSetup() {
        adapter = PostAdapter(posts)
        binding.mListRV.layoutManager = LinearLayoutManager(this)
        binding.mListRV.adapter = adapter
    }

    private fun vmSetup() {
        viewModel.posts.observe(this, renderPosts)
    }

    private val renderPosts = Observer<List<Post>> {
        Log.v(tag, "data updated $it")
        adapter.submitList(it)
    }
}