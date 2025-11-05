package com.example.kotlinlockin.common.data

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle

import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


import com.example.kotlinlockin.common.data.entity.Example


fun getStylingTextExamples(): List<Example> = listOf(
    Example(
        title = "\uD83E\uDDE9 1. Basic text styling",
        code = "Text(\n" + "    text = \"Hello Compose\",\n" + "    color = Color.Blue,\n" + "    fontSize = 24.sp,\n" + "    fontWeight = FontWeight.Bold,\n" + "    fontStyle = FontStyle.Italic\n" + ")",
        description = "You can directly set styling using parameters inside the Text composable." + "Explanation:\n" + "\t•\tcolor → changes text color\n" + "\t•\tfontSize → changes font size (sp = scale-independent pixels)\n" + "\t•\tfontWeight → sets thickness (e.g., Bold, Medium, Light)\n" + "\t•\tfontStyle → Italic or Normal",
        composableWidget = {
            Text(
                text = "Hello Compose",
                color = Color.Blue,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic
            )
        }),

    Example(
        title = "\uD83E\uDDE9 2. Using TextStyle for cleaner code",
        code = "Text(\n" + "    text = \"Styled using TextStyle\",\n" + "    style = TextStyle(\n" + "        color = Color(0xFF1E88E5),\n" + "        fontSize = 20.sp,\n" + "        fontWeight = FontWeight.SemiBold,\n" + "        letterSpacing = 1.sp\n" + "    )\n" + ")",
        description = "You can group all styles using the style parameter." + "Why use TextStyle:\n" + "It helps reuse and combine multiple styles easily — especially useful in apps with a consistent design system.",
        composableWidget = {
            Text(
                text = "Styled using TextStyle", style = TextStyle(
                    color = Color(0xFF1E88E5),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    letterSpacing = 1.sp
                )
            )
        }),

    Example(
        title = "\uD83E\uDDE9 3. Using Material Theme typography",
        code = "Text(\n" + "    text = \"Material Headline\",\n" + "    style = MaterialTheme.typography.headlineMedium\n" + ")" + "\n====================================" + "Text(\n" + "    text = \"Custom Title\",\n" + "    style = MaterialTheme.typography.titleLarge.copy(\n" + "        color = Color.Red,\n" + "        fontWeight = FontWeight.Bold\n" + "    )\n" + ")",
        description = "Compose Material3 provides pre-defined text styles using the MaterialTheme.typography system." + "You can also override specific attributes:" + "Explanation:\n" + "\t•\tTypography provides a consistent text system for your entire app (title, headline, body, etc.).\n" + "\t•\tYou can customize color, weight, or size using .copy().",
        composableWidget = {
            Text(
                text = "Material Headline", style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = "Custom Title", style = MaterialTheme.typography.titleLarge.copy(
                    color = Color.Red, fontWeight = FontWeight.Bold
                )
            )
        }),

    Example(
        title = "⚙\uFE0F 7. Example: Combining all text styles",
        code = "Text(\n" + "    text = \"Styled Text Example\",\n" + "    modifier = Modifier.padding(16.dp),\n" + "    style = TextStyle(\n" + "        color = Color(0xFF6200EE),\n" + "        fontSize = 22.sp,\n" + "        fontWeight = FontWeight.Bold,\n" + "        fontStyle = FontStyle.Italic,\n" + "        textDecoration = TextDecoration.Underline,\n" + "        textAlign = TextAlign.Center,\n" + "        letterSpacing = 1.sp\n" + "    )\n" + ")",
        description = "",
        composableWidget = {
            Text(
                text = "Styled Text Example", modifier = Modifier.padding(16.dp), style = TextStyle(
                    color = Color(0xFF6200EE),
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic,
                    textDecoration = TextDecoration.Underline,
                    textAlign = TextAlign.Center,
                    letterSpacing = 1.sp
                )
            )
        })
)