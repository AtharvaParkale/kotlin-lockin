package com.example.kotlinlockin.common.composables

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TopicCardWithTitleCodeDescription(
    title: String,
    code: String,
    description: String,
    composableWidget: @Composable () -> Unit,
) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            Modifier.padding(10.dp)
        ) {
            Text(
                title, style = TextStyle(
                    fontWeight = FontWeight.Bold, color = Color.Black, fontSize = 18.sp
                )
            )
            Box(modifier = Modifier.height(10.dp))
            Box(
                modifier = Modifier
                    .padding(all = 5.dp)
                    .border(2.dp, color = Color.Gray)
            ) {
                Text(
                    modifier = Modifier.padding(all = 5.dp), text = code
                )
            }
            Box(modifier = Modifier.height(15.dp))
            Text(
                text = description
            )
            Box(modifier = Modifier.height(15.dp))
            composableWidget()
        }
    }
}