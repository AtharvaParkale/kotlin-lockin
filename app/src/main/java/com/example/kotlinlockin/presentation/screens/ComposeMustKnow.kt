package com.example.kotlinlockin.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ComposeMustKnow() {

    Column(
        modifier = Modifier.padding(
            horizontal = 15.dp,
            vertical = 18.dp
        ),
        verticalArrangement = Arrangement.spacedBy(space = 20.dp),
    ) {
        Text("1. What is the syntax for modifiers ?")
        Box(modifier = Modifier.height(8.dp))
        Text("2. How to iterate a list in compose and render UI ?")
        Box(modifier = Modifier.height(8.dp))
        Text("2. How to iterate a list in compose and render UI ?")
    }
}

