package com.example.kotlinlockin.presentation.screens.view_model.domain.usecase

import com.example.kotlinlockin.presentation.screens.view_model.domain.model.Post
import com.example.kotlinlockin.presentation.screens.view_model.domain.repository.PostRepository

class GetAllPostsUseCase(
    private val repository: PostRepository
) {
    suspend fun call(): List<Post> {
        return repository.getAllPosts();
    }
}