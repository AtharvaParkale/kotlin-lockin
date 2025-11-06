package com.example.kotlinlockin.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kotlinlockin.common.composables.CommonQuestionsCard
import com.example.kotlinlockin.common.data.CommonQuestionsModel
import com.example.kotlinlockin.common.data.getAllCommonQuestions

@Composable
fun ComposeMustKnow() {
    val questions: List<CommonQuestionsModel> = remember { getAllCommonQuestions() }

    Column(
        modifier = Modifier.padding(
            horizontal = 15.dp, vertical = 18.dp
        ),
        verticalArrangement = Arrangement.spacedBy(space = 10.dp),
    ) {
        questions.forEach { it ->
            CommonQuestionsCard(
                item = it,
            )
        }
    }
}

