package com.example.kotlinlockin.presentation.screens

import BoxComposable
import RowComposable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun KotlinLayOutScreen() {
    Column(
        modifier = Modifier.padding(
            horizontal = 15.dp,
            vertical = 18.dp
        ),
        verticalArrangement = Arrangement.spacedBy(space = 20.dp),
    ) {
        RowComposable()
        BoxComposable()
    }
}