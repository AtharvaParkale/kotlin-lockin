package com.example.kotlinlockin.presentation.screens.view_model.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlinlockin.presentation.screens.view_model.presentation.viewmodel.PostsViewModel

@Composable
fun PostsScreen(viewModel: PostsViewModel) {
    val state = viewModel.state.value

    Column(
        modifier = Modifier.padding(horizontal = 15.dp, vertical = 18.dp)
    ) {
        // Button outside LazyColumn
        Button(onClick = { viewModel.getAllPosts() }) {
            Text("Get all the posts")
        }

        Spacer(modifier = Modifier.height(20.dp))

        when {
            state.isLoading -> {
                Box(
                    Modifier.fillMaxWidth(), contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            state.error != null -> {
                Text(
                    text = state.error, color = Color.Red, modifier = Modifier.padding(10.dp)
                )
            }

            state.posts != null -> {
                LazyColumn(
                    modifier = Modifier.height(height = 800.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                ) {
                    items(state.posts) { post ->
                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            elevation = CardDefaults.cardElevation(2.dp)
                        ) {
                            Text(
                                text = post.body, style = TextStyle(
                                    fontWeight = FontWeight.W600, fontSize = 16.sp
                                ), modifier = Modifier.padding(15.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}