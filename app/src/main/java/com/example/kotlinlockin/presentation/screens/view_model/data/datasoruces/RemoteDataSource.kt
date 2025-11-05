package com.example.kotlinlockin.presentation.screens.view_model.data.datasoruces

import com.example.kotlinlockin.presentation.screens.view_model.data.entities.PostResponse
import retrofit2.http.GET

interface RemoteDataSource {
    @GET("posts")
    suspend fun getAllPosts(): List<PostResponse>
}