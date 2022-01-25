package com.sample.userapplication.network

import com.sample.userapplication.network.model.UserItem
import retrofit2.http.GET

interface Api {
    @GET("users")
    suspend fun getUsers() : List<UserItem>
}