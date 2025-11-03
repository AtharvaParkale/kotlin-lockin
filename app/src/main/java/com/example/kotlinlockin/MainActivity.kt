package com.example.kotlinlockin

import CodeViewer
import NavigationDrawer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.kotlinlockin.ui.theme.KotlinLockInTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinLockInTheme {
//                Scaffold(
//                    modifier = Modifier.fillMaxSize(),
//                    containerColor = Color.White,
//                ) { innerPadding ->
//                    Column(
//                        modifier = Modifier.verticalScroll(rememberScrollState()),
//                        horizontalAlignment = Alignment.Start
//                    ) {
//                        NavigationDrawer()
////                        NavigationStack()
////                        KotlinLayOutScreen()
//                    }
//                }
                NavigationDrawer()
            }
        }
    }
}