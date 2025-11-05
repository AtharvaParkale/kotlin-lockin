package com.example.kotlinlockin.common.data.entity

import androidx.compose.runtime.Composable

data class Example(
    val title: String,
    val code: String,
    val description: String,
    val composableWidget: @Composable () -> Unit
)