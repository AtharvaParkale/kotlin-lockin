package com.example.kotlinlockin.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlinlockin.common.composables.TopicCardWithTitleCodeDescription
import com.example.kotlinlockin.common.data.getRecompositionExample

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RecompositionTutorial() {
    val examples = remember { getRecompositionExample() }
    Column(
        modifier = Modifier.padding(
            horizontal = 15.dp, vertical = 20.dp
        ), verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        examples.forEach { example ->
            TopicCardWithTitleCodeDescription(
                title = example.title, code = example.code, description = example.description
            )
        }
    }
}

