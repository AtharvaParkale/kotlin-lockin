package com.example.kotlinlockin.presentation.screens.view_model.presentation.viewmodel

import com.example.kotlinlockin.presentation.screens.view_model.domain.model.Post

data class PostsUiState(
    val isLoading: Boolean = false,
    val posts: List<Post>? = null,
    val error: String? = null
)