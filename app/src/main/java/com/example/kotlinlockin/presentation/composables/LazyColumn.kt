package com.example.kotlinlockin.presentation.composables

import TopicTemplate
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp


val itemList = List(100) { index -> "Item ${index + 1}" }

@Composable
fun LazyColumnComposable() {
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    TopicTemplate(
        "LazyColumn",
        description = "Box(modifier=Modifier.fillMaxWidth().height(height=screenHeight/3)){LazyColumn{items(itemList){item->Text(item,modifier=Modifier.padding(vertical=5.dp))}}}"
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(
                    height = screenHeight / 3
                )
        ) {
            LazyColumn {
                items(itemList) { item ->
                    Text(
                        item, modifier = Modifier.padding(
                            vertical = 5.dp
                        )
                    )
                }
            }
        }
    }
}