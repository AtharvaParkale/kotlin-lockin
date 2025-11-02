package com.example.kotlinlockin.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun IntrinsicMeasurements() {
    Column(
        modifier = Modifier.padding(
            horizontal = 15.dp, vertical = 18.dp
        ),
    ) {

        Text(
            text = "To achieve this sort of UI, we need intrinsic height measurements." + "\n We have a Row(fillMaxWidth, height(IntrinsicSize.Max))," + "\n Inside the row we have two columns left and right, each having .fillMaxHeight"
        )
        Box(Modifier.height(height = 10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Max)
                .background(Color.Gray),
            horizontalArrangement = Arrangement.Center
        ) {
            Column(
                Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Green)
            ) {
                Text("Item 1", color = Color.Black)
                Text("Item 2", color = Color.Black)
                Text("Item 3", color = Color.Black)
            }
            Column(
                Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Yellow),
            ) {
                Text("Item 1", color = Color.Black)
                Text("Item 2", color = Color.Black)
                Text("Item 3", color = Color.Black)
                Text("Item 4", color = Color.Black)
                Text("Item 5", color = Color.Black)
                Text("Item 6", color = Color.Black)
            }
        }
        Box(Modifier.height(height = 25.dp))
        Text(
            text = "Without intrinsic height this is the UI"
        )
        Box(Modifier.height(height = 10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Gray),
            horizontalArrangement = Arrangement.Center
        ) {
            Column(
                Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Green)
            ) {
                Text("Item 1", color = Color.Black)
                Text("Item 2", color = Color.Black)
                Text("Item 3", color = Color.Black)
            }
            Column(
                Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Yellow),
            ) {
                Text("Item 1", color = Color.Black)
                Text("Item 2", color = Color.Black)
                Text("Item 3", color = Color.Black)
                Text("Item 4", color = Color.Black)
                Text("Item 5", color = Color.Black)
                Text("Item 6", color = Color.Black)
            }
        }
    }
}