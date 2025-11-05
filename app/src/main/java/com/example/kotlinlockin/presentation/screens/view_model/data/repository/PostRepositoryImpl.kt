package com.example.kotlinlockin.presentation.screens.view_model.data.repository

import com.example.kotlinlockin.presentation.screens.view_model.data.datasoruces.RemoteDataSource
import com.example.kotlinlockin.presentation.screens.view_model.domain.model.Post
import com.example.kotlinlockin.presentation.screens.view_model.domain.repository.PostRepository

class PostRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
) : PostRepository {
    override suspend fun getAllPosts(): List<Post> {
        val response = remoteDataSource.getAllPosts()
        return response.map { it.toEntity() }
    }
}