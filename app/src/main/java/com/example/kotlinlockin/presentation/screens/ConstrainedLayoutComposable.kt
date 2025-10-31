package com.example.kotlinlockin.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.kotlinlockin.R

@SuppressLint("ConfigurationScreenWidthHeight")
@Composable
fun ConstrainedLayoutComposable() {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    Column(
        modifier = Modifier.padding(
            horizontal = 15.dp,
            vertical = 18.dp
        ),
    ) {
        ConstrainedLayoutExampleOne(screenHeight / 2)
        ConstrainedLayoutExampleExampleTwo(screenHeight / 2)
        ConstrainedLayoutExampleExampleThree(screenHeight / 2)
    }
}

@Composable
private fun ConstrainedLayoutExampleOne(screenHeight: Dp) {
    Surface(
        modifier = Modifier
            .height(height = screenHeight)
            .fillMaxWidth(),
        color = Color(0xFFB3E5FC)
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
        ) {
            val (title, button, description) = createRefs()

            Text(
                text = "Welcome Demo", modifier = Modifier.constrainAs(title) {
                    top.linkTo(parent.top, margin = 32.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                })

            Button(onClick = {}, modifier = Modifier.constrainAs(button) {
                top.linkTo(title.bottom, margin = 16.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }) {
                Text("Get Started")
            }
            Text(
                text = "\t•\tConstraintLayout → The parent layout controlling positioning.\n" +
                        "\t•\tcreateRefs() → Creates references for title and button.\n" +
                        "\t•\tText → Positioned at the top center of the screen using top.linkTo(parent.top) and centering with start + end.\n" +
                        "\t•\tButton → Positioned below the text using top.linkTo(title.bottom) so it keeps a fixed vertical distance.\n" +
                        "✅ Result → Text appears at the top; button neatly placed below it and both are centered horizontally.",
                modifier = Modifier.constrainAs(ref = description) {
                    top.linkTo(anchor = button.bottom, margin = 16.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            )

        }
    }
}

@Composable
fun ConstrainedLayoutExampleExampleTwo(screenHeight: Dp) {
    Surface(
        modifier = Modifier
            .height(height = screenHeight)
            .fillMaxWidth(),
        color = Color(0xFFFFF9C4)
    ) {
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val (image, title, subtitle, description) = createRefs()

            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .constrainAs(image) {
                        top.linkTo(parent.top, margin = 40.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    })

            Text(
                text = "Atharva Parkale", modifier = Modifier.constrainAs(title) {
                    top.linkTo(image.bottom, margin = 1.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                })

            Text(
                text = "Flutter & Kotlin Developer",
                modifier = Modifier.constrainAs(subtitle) {
                    top.linkTo(title.bottom, margin = 8.dp)
                    start.linkTo(title.start)
                    end.linkTo(title.end)
                })

            Text(
                text = "\t•\tImage → Centered horizontally and placed at the top with a margin.\n" +
                        "\t•\tTitle Text → Positioned below the image.\n" +
                        "\t•\tSubtitle Text → Placed below the title and aligned with it horizontally.\n" +
                        "✅ Result → A vertically stacked layout (image → title → subtitle) without using a Column, keeping flexibility for responsive alignment.",
                modifier = Modifier.constrainAs(description) {
                    top.linkTo(subtitle.bottom, margin = 8.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                })
        }
    }
}

@Composable
fun ConstrainedLayoutExampleExampleThree(screenHeight: Dp) {
    Surface(
        modifier = Modifier
            .height(height = screenHeight)
            .fillMaxWidth(),
        color = Color(0xFFD1C4E9)
    ) {
        ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
            val (btn1, btn2, btn3, description) = createRefs()

            createHorizontalChain(btn1, btn2, btn3, chainStyle = ChainStyle.Spread)

            Button(
                onClick = {},
                modifier = Modifier.constrainAs(btn1) {
                    top.linkTo(parent.top, margin = 32.dp)
                }
            ) { Text("Left") }

            Button(
                onClick = {},
                modifier = Modifier.constrainAs(btn2) {
                    top.linkTo(btn1.top)
                }
            ) { Text("Center") }

            Button(
                onClick = {},
                modifier = Modifier.constrainAs(btn3) {
                    top.linkTo(btn1.top)
                }
            ) { Text("Right") }

            Text(
                text = "\t•\tImage → Centered horizontally and placed at the top with a margin.\n" +
                        "\t•\tTitle Text → Positioned below the image.\n" +
                        "\t•\tSubtitle Text → Placed below the title and aligned with it horizontally.\n" +
                        "✅ Result → A vertically stacked layout (image → title → subtitle) without using a Column, keeping flexibility for responsive alignment.",
                modifier = Modifier.constrainAs(description) {
                    top.linkTo(btn2.bottom, margin = 8.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                })
        }
    }
}