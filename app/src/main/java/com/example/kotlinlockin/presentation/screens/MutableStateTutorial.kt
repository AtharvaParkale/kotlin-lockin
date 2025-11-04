package com.example.kotlinlockin.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kotlinlockin.common.composables.TopicCardWithTitleCodeDescription
import com.example.kotlinlockin.common.data.getMutableStateExamples

@Composable
fun MutableStateTutorial() {
    val stringState = remember { mutableStateOf("") }
    val examples = remember { getMutableStateExamples() }
    Column(
        modifier = Modifier.padding(
            horizontal = 15.dp, vertical = 20.dp
        ),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {

        examples.forEach {
            it
            TopicCardWithTitleCodeDescription(
                title = it.title,
                code = it.code,
                description = it.description,
                composableWidget = it.composableWidget,
            )
        }
    }
}