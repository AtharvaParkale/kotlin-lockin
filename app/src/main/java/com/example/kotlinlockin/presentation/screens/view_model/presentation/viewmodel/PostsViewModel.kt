package com.example.kotlinlockin.presentation.screens.view_model.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinlockin.presentation.screens.view_model.domain.usecase.GetAllPostsUseCase
import kotlinx.coroutines.launch

class PostsViewModel(
    private val getAllPostsUseCase: GetAllPostsUseCase
) : ViewModel() {
    var state = androidx.compose.runtime.mutableStateOf(PostsUiState())
        private set

    fun getAllPosts() {
        viewModelScope.launch {
            try {
                state.value = state.value.copy(isLoading = true)
                val posts = getAllPostsUseCase.call()
                state.value = PostsUiState(posts = posts)

            } catch (e: Exception) {
                state.value = PostsUiState(error = e.message ?: "Unknown error")
            }

        }
    }
}