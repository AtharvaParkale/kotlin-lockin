package com.example.kotlinlockin.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ComposeMustKnow() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text("1. What is the syntax for modifiers ?")
            Spacer(modifier = Modifier.height(8.dp))
            Text("2. How to iterate a list in compose and render UI ?")
            Spacer(modifier = Modifier.height(8.dp))
            Text("2. How to iterate a list in compose and render UI ?")
        }
    }
}
