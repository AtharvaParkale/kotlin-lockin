package com.example.kotlinlockin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlinlockin.ui.theme.KotlinLockInTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinLockInTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = Color.White,
                ) { innerPadding ->
                    Column(
                        modifier = Modifier.verticalScroll(rememberScrollState()),
                        horizontalAlignment = Alignment.Start
                    ) {
                        TopAppBarComposable()
                        Column(
                            modifier = Modifier.padding(
                                horizontal = 15.dp,
                                vertical = 18.dp
                            ),
                            verticalArrangement = Arrangement.spacedBy(space = 20.dp),
                        ) {
                            RowTexts()
                            ComposableLayouts()
                        }
                    }

                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarComposable() {
    TopAppBar(
        title = {
            Text(text = "Compose practice")
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(Icons.Default.Menu, contentDescription = "Menu")
            }
        },
    )
}


@Composable
fun RowTexts() {
    Column {
        Heading("Rows")
        Box(modifier = Modifier.size(10.dp))
        Row {
            Text(
                text = "Text1",
                modifier = Modifier.background(Color.Red),
                fontWeight = FontWeight(weight = 500)
            )
            Text(
                text = "Text2",
                modifier = Modifier.background(Color.Blue),
                fontWeight = FontWeight(weight = 500)
            )
            Text(
                text = "Text3",
                modifier = Modifier.background(Color.Yellow),
                fontWeight = FontWeight(weight = 500)
            )
        }
    }
}

@Composable
fun ComposableLayouts() {
    Column {
        Heading("Box")
        Box(modifier = Modifier.size(10.dp))
        Box(
            Modifier
                .background(
                    Color.Gray
                )
                .padding(all = 10.dp)
                .size(250.dp)
        ) {
            Text(
                "Center",
                Modifier.align(Alignment.Center),
                fontWeight = FontWeight(weight = 500),
                color = Color.White
            )
            Text(
                "Top Start",
                Modifier.align(Alignment.TopStart),
                fontWeight = FontWeight(weight = 500),
                color = Color.White
            )
            Text(
                "Top End",
                Modifier.align(Alignment.TopEnd),
                fontWeight = FontWeight(weight = 500),
                color = Color.White
            )
            Text(
                "Bottom Start",
                Modifier.align(Alignment.BottomStart),
                fontWeight = FontWeight(weight = 500),
                color = Color.White
            )
            Text(
                "Bottom End",
                Modifier.align(Alignment.BottomEnd),
                fontWeight = FontWeight(weight = 500),
                color = Color.White
            )
        }
    }
}

@Composable
fun Heading(title: String) {
    Text(
        text = "=> $title",
        fontWeight = FontWeight(weight = 600),
        fontSize = 20.sp
    )
}

