package com.example.kotlinlockin.common.data

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.kotlinlockin.common.data.entity.Example


fun getButtonClicksExamples(): List<Example> = listOf(

    Example(
        title = "1\uFE0F⃣ What are Buttons and Clickable Components",
        code = "",
        description = "In Jetpack Compose, a clickable component is any composable that can respond to user touch or click actions.\n" + "You can make almost any UI element clickable — not just Button.\n" + "\n" + "Buttons (like Button, TextButton, OutlinedButton, etc.) are pre-styled clickable components, while modifiers like Modifier.clickable {} can turn any composable into an interactive one."
    ) {}, Example(
        title = "2\uFE0F⃣ Basic Button Example",
        code = "@Composable\n" + "fun SimpleButtonExample() {\n" + "    Button(onClick = { println(\"Button clicked!\") }) {\n" + "        Text(text = \"Click Me\")\n" + "    }\n" + "}",
        description = "✅ Explanation:\n" + "\t•\tButton() is a Material3 composable that provides default padding, color, and ripple effect.\n" + "\t•\tonClick defines the action executed when tapped.\n" + "\t•\tYou can place any content inside — typically a Text."
    ) {
        Button(onClick = { println("Button clicked!") }) {
            Text(text = "Click Me")
        }
    }, Example(
        title = "3\uFE0F⃣ Outlined and Text Buttons",
        code = "OutlinedButton(onClick = { println(\"Outlined button clicked!\") }) {\n" + "    Text(\"Outlined Button\")\n" + "}" + "\n================================" + "TextButton(onClick = { println(\"Text button clicked!\") }) {\n" + "    Text(\"Text Button\")\n" + "}",
        description = "✅ Use cases:\n" + "\t•\tOutlinedButton → subtle action (e.g., “Cancel”)\n" + "\t•\tTextButton → secondary or inline actions"
    ) {
        Column {
            OutlinedButton(onClick = { println("Outlined button clicked!") }) {
                Text("Outlined Button")
            }
            TextButton(onClick = { println("Text button clicked!") }) {
                Text("Text Button")
            }
        }
    }, Example(
        title = "4\uFE0F⃣ Icon Button",
        code = "IconButton(onClick = { println(\"Icon clicked!\") }) {\n" + "    Icon(\n" + "        imageVector = Icons.Filled.Favorite,\n" + "        contentDescription = \"Favorite\"\n" + "    )\n" + "}",
        description = "✅ Explanation:\n" + "\t•\tUsed when only an icon is needed (no text).\n" + "\t•\tCommon for toolbars, like favorite, share, or back actions."
    ) {
        IconButton(onClick = { println("Icon clicked!") }) {
            Icon(
                imageVector = Icons.Filled.Favorite, contentDescription = "Favorite"
            )
        }
    }, Example(
        title = "5\uFE0F⃣ Making any composable clickable",
        code = "Box(\n" + "        modifier = Modifier\n" + "            .size(100.dp)\n" + "            .background(Color.LightGray)\n" + "            .clickable { println(\"Box clicked!\") },\n" + "        contentAlignment = Alignment.Center\n" + "    ) {\n" + "        Text(\"Tap Me\")\n" + "    }",
        description = "You can make any element clickable using Modifier.clickable { ... }." + "✅ Explanation:\n" + "\t•\tModifier.clickable {} makes the Box respond to taps.\n" + "\t•\tAny Composable can become interactive using this modifier.\n"
    ) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.LightGray)
                .clickable { println("Box clicked!") }, contentAlignment = Alignment.Center
        ) {
            Text("Tap Me")
        }
    }, Example(
        title = "6\uFE0F⃣ Button with State (like toggle)",
        description = "✅ Explanation:\n" + "\t•\tUses remember { mutableStateOf() } to keep track of click state.\n" + "\t•\tThe button color and text change dynamically on each click.",
        code = " var isClicked by remember { mutableStateOf(false) }\n" + "\n" + "    Button(\n" + "        onClick = { isClicked = !isClicked },\n" + "        colors = ButtonDefaults.buttonColors(\n" + "            containerColor = if (isClicked) Color.Green else Color.Gray\n" + "        )\n" + "    ) {\n" + "        Text(if (isClicked) \"Clicked!\" else \"Click Me\")\n" + "    }"
    ) {
        var isClicked by remember { mutableStateOf(false) }

        Button(
            onClick = { isClicked = !isClicked }, colors = ButtonDefaults.buttonColors(
                containerColor = if (isClicked) Color.Green else Color.Gray
            )
        ) {
            Text(if (isClicked) "Clicked!" else "Click Me")
        }
    }, Example(
        title = "7\uFE0F⃣ Clickable Row or Image Example",
        description = "✅ Explanation:\n" + "\t•\tThe whole Row acts as one clickable area.\n" + "\t•\tYou can combine multiple components (icon + text) in a single tap target.",
        code = "    Row(\n" + "        modifier = Modifier\n" + "            .fillMaxWidth()\n" + "            .clickable { println(\"Row clicked!\") }\n" + "            .padding(16.dp),\n" + "        verticalAlignment = Alignment.CenterVertically\n" + "    ) {\n" + "        Icon(\n" + "            imageVector = Icons.Filled.PlayArrow,\n" + "            contentDescription = \"Play\"\n" + "        )\n" + "        Spacer(Modifier.width(8.dp))\n" + "        Text(\"Play Video\")\n" + "    }",
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { println("Row clicked!") }
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Filled.PlayArrow, contentDescription = "Play"
            )
            Spacer(Modifier.width(8.dp))
            Text("Play Video")
        }
    },

    Example(
        title = "8\uFE0F⃣ Button Styling Example",
        description = "✅ Explanation:\n" + "\t•\tButtonDefaults helps you set custom colors, elevation, and shape easily.",
        code = "Button(\n" + "    onClick = { println(\"Styled button clicked!\") },\n" + "    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1565C0)),\n" + "    shape = RoundedCornerShape(10.dp),\n" + "    elevation = ButtonDefaults.buttonElevation(6.dp)\n" + ") {\n" + "    Text(\"Styled Button\", color = Color.White)\n" + "}",
    ) {
        Button(
            onClick = { println("Styled button clicked!") },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1565C0)),
            shape = RoundedCornerShape(10.dp),
            elevation = ButtonDefaults.buttonElevation(6.dp)
        ) {
            Text("Styled Button", color = Color.White)
        }
    }, Example(
        title = "\uD83E\uDDE0 Summary Notes",
        description = "\t•\tButton(onClick = {}) → standard clickable element\n" + "\t•\tOutlinedButton & TextButton → less prominent alternatives\n" + "\t•\tIconButton → for icons only\n" + "\t•\tModifier.clickable {} → makes any composable clickable\n" + "\t•\tButtons can be styled with colors, shapes, and elevation\n" + "\t•\tUse remember { mutableStateOf() } for dynamic UI updates on click",
        code = "",
    ) {

    }
)