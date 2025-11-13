package com.example.kotlinlockin.common.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
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
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.onBackground)
    ) {
        Column(
            modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            Text(
                text = title, style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.background
                ), maxLines = 2, overflow = TextOverflow.Ellipsis
            )

            Divider(color = Color(0xFFDDDDDD))

            if (code.isNotEmpty()) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color(0xFFF4F4F4))
                        .border(1.dp, Color(0xFFDADADA), RoundedCornerShape(10.dp))
                        .padding(5.dp)
                        .background(MaterialTheme.colorScheme.background)
                ) {
                    Text(
                        text = code, style = TextStyle(
                            fontSize = 13.sp,
                            fontFamily = MaterialTheme.typography.bodySmall.fontFamily,
                            lineHeight = 18.sp,
                            color = MaterialTheme.colorScheme.onBackground
                        ), modifier = Modifier
                            .clip(RoundedCornerShape(10.dp))
                            .padding(10.dp)
                    )
                }
            }

            if (description.isNotEmpty()) {
                Text(
                    text = description, style = TextStyle(
                        fontSize = 15.sp,
                        lineHeight = 20.sp,
                        color = MaterialTheme.colorScheme.background
                    )
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                contentAlignment = Alignment.Center
            ) {
                composableWidget()
            }
        }
    }
}