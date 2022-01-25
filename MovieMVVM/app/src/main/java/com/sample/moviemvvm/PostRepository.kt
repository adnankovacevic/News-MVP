package com.sample.moviemvvm

import javax.inject.Inject

class PostRepository @Inject constructor(private val postApi: PostApi) {

    suspend fun getPosts() = postApi.getPosts()
}