package com.example.kotlinlockin.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.kotlinlockin.navigation.Screen


@Composable
fun NavigationScreenOne(navController: NavController) {
    val text = remember {
        mutableStateOf("")
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        OutlinedTextField(value = text.value, onValueChange = {
            text.value = it
        })

        Button(onClick = {
            navController.navigate(route = Screen.NavScreenTwo.route + "?text=${text.value}")
        }) {
            Text("Next Screen")
        }
    }
}