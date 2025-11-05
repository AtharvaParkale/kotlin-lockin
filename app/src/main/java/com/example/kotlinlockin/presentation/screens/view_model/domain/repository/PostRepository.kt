package com.example.kotlinlockin.presentation.screens.view_model.domain.repository

import com.example.kotlinlockin.presentation.screens.view_model.domain.model.Post

interface PostRepository {
    suspend fun getAllPosts(): List<Post>
}