package com.example.kotlinlockin.presentation.screens.view_model.presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.example.kotlinlockin.presentation.screens.view_model.data.datasoruces.RemoteDataSource
import com.example.kotlinlockin.presentation.screens.view_model.data.repository.PostRepositoryImpl
import com.example.kotlinlockin.presentation.screens.view_model.domain.usecase.GetAllPostsUseCase
import com.example.kotlinlockin.presentation.screens.view_model.presentation.viewmodel.PostsViewModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun PostScreenInitialization() {
    val retrofit = remember {
        Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    val api = remember { retrofit.create(RemoteDataSource::class.java) }
    val repo = remember { PostRepositoryImpl(api) }
    val useCase = remember { GetAllPostsUseCase(repo) }
    val viewModel = remember { PostsViewModel(useCase) }

    // Now pass to your UI
    PostsScreen(viewModel)
}