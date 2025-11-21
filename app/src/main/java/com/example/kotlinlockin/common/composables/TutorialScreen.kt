package com.example.kotlinlockin.common.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.kotlinlockin.common.data.entity.Example


@Composable
fun TutorialScreen(exampleList: List<Example>) {
    val examples = remember { exampleList }
    val navController = rememberNavController()
    Column(
        modifier = Modifier.padding(
            horizontal = 15.dp, vertical = 20.dp
        ), verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        examples.forEach { example ->
            TopicCardWithTitleCodeDescription(
                title = example.title,
                code = example.code,
                description = example.description,
                composableWidget = example.composableWidget,
            )
        }
    }
}


