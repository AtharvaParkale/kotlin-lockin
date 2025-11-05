package com.example.kotlinlockin.presentation.screens.view_model.data.entities

import com.example.kotlinlockin.presentation.screens.view_model.domain.model.Post


data class PostResponse(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
) {
    fun toEntity(): Post {
        return Post(
            userId = userId,
            id = id,
            title = title,
            body = body
        )
    }
}