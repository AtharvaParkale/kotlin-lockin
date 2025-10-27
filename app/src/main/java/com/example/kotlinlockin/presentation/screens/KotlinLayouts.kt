package com.example.kotlinlockin.presentation.screens

import BoxComposable
import LazyRowComposable
import RowComposable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlinlockin.presentation.composables.LazyColumnComposable

@Preview(showBackground = true, showSystemUi = true)
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
        LazyColumnComposable()
        LazyRowComposable()
    }
}