package com.example.kotlinlockin

import NavigationDrawer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinlockin.presentation.screens.live_data.TimerViewModel
import com.example.kotlinlockin.ui.theme.KotlinLockInTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            KotlinLockInTheme {
                NavigationDrawer()
            }
        }
    }
}