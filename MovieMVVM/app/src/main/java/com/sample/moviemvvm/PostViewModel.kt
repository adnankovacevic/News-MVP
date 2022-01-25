package com.sample.moviemvvm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(val repository: PostRepository) : ViewModel() {

    private val _posts = MutableLiveData<List<Post>>()
    val posts: LiveData<List<Post>> = _posts

    init {
        getPosts()
    }

    private fun getPosts() = viewModelScope.launch {
        repository.getPosts().let {
            if (it.isSuccessful) {
                _posts.postValue(it.body())
            } else {
                Log.d("TAG", "getPosts Error: ${it.code()}")
            }
        }
    }
}
