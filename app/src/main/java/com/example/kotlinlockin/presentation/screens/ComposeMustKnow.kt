package com.example.kotlinlockin.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlinlockin.common.data.getAllCommonQuestions

@Composable
fun ComposeMustKnow() {
    val questions: List<String> = remember { getAllCommonQuestions() }

    Column(
        modifier = Modifier.padding(
            horizontal = 15.dp, vertical = 18.dp
        ),
        verticalArrangement = Arrangement.spacedBy(space = 10.dp),
    ) {
        questions.forEach { it ->
            Card(Modifier.fillMaxWidth()) {
                Box(Modifier.padding(horizontal = 10.dp, vertical = 15.dp)) {
                    Text(
                        it, style = TextStyle(
                            fontWeight = FontWeight.W600,
                            fontSize = 16.sp
                        )
                    )
                }
            }
        }
    }
}

