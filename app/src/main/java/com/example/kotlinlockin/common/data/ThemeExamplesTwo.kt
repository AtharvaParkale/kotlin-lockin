package com.example.kotlinlockin.common.data

import com.example.kotlinlockin.common.data.entity.Example


fun getThemeExamplesPartTwo(): List<Example> = listOf(
    Example(
        title = " 1\uFE0F⃣ Basic Idea",
        description = "When you define both light and dark color schemes (in Theme.kt),\n" + "Compose automatically gives you access to those colors through" + "Each property inside colorScheme (like primary, onBackground, etc.) will automatically change depending on whether your app is in dark or light mode.\n" + "\n" + "So — instead of using hardcoded colors like Color.Black or Color.White,\n" + "✅ You should always use semantic colors from your theme.",
        code = "MaterialTheme.colorScheme"
    ) {

    },
    Example(
        title = "2\uFE0F⃣ Example: Using Theme Colors in Text",
        description = "Here’s how you can make text automatically adapt to light and dark themes \uD83D\uDC47" + "\n ✅ What happens:\n" + "\t•\tWhen in light theme, these colors might look like:\n" + "\t•\tprimary = Blue\n" + "\t•\tonBackground = Black\n" + "\t•\tWhen in dark theme, they automatically change to:\n" + "\t•\tprimary = Light Blue\n" + "\t•\tonBackground = White\n" + "\n" + "All of this comes from your color scheme definitions.\n",
        code = "@Composable\n" + "fun ThemedTextExample() {\n" + "    Column(\n" + "        modifier = Modifier\n" + "            .fillMaxWidth()\n" + "            .padding(16.dp)\n" + "            .background(MaterialTheme.colorScheme.background)\n" + "    ) {\n" + "        Text(\n" + "            text = \"Primary Text\",\n" + "            color = MaterialTheme.colorScheme.primary,\n" + "            style = MaterialTheme.typography.titleLarge\n" + "        )\n" + "\n" + "        Text(\n" + "            text = \"Secondary Text\",\n" + "            color = MaterialTheme.colorScheme.secondary,\n" + "            style = MaterialTheme.typography.bodyLarge\n" + "        )\n" + "\n" + "        Text(\n" + "            text = \"Normal onBackground Text\",\n" + "            color = MaterialTheme.colorScheme.onBackground,\n" + "            style = MaterialTheme.typography.bodyLarge\n" + "        )\n" + "    }\n" + "}"
    ) {

    },
    Example(
        title = "4\uFE0F⃣ Example with Both Light and Dark Mode in Action",
        description = "✅ Explanation:\n" + "\t•\tThe background color of the card is surface.\n" + "\t•\tText color is onSurface, which automatically contrasts with surface.\n" + "\t•\tError text uses error, which is red in both modes.",
        code = "@Composable\n" + "fun ThemedTextCard() {\n" + "    Card(\n" + "        modifier = Modifier\n" + "            .padding(16.dp)\n" + "            .fillMaxWidth(),\n" + "        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)\n" + "    ) {\n" + "        Column(modifier = Modifier.padding(16.dp)) {\n" + "            Text(\n" + "                text = \"Themed Card Example\",\n" + "                color = MaterialTheme.colorScheme.onSurface,\n" + "                style = MaterialTheme.typography.titleLarge\n" + "            )\n" + "\n" + "            Text(\n" + "                text = \"This text automatically adapts to dark or light mode.\",\n" + "                color = MaterialTheme.colorScheme.onSurface,\n" + "                style = MaterialTheme.typography.bodyLarge\n" + "            )\n" + "\n" + "            Text(\n" + "                text = \"Error Example\",\n" + "                color = MaterialTheme.colorScheme.error,\n" + "                style = MaterialTheme.typography.bodyMedium\n" + "            )\n" + "        }\n" + "    }\n" + "}"
    ) {

    },
    Example(
        title = "5\uFE0F⃣ Quick Example of Theme Definitions",
        description = "In Theme.kt, you probably already have something like this:" + "\n Now — when you use:\n" + "Compose will pick black in light theme and white in dark theme automatically.",
        code = "private val LightColorScheme = lightColorScheme(\n" + "    primary = Color(0xFF1565C0),\n" + "    onPrimary = Color.White,\n" + "    background = Color(0xFFFFFFFF),\n" + "    onBackground = Color.Black,\n" + "    surface = Color(0xFFF8F8F8),\n" + "    onSurface = Color.Black\n" + ")\n" + "\n" + "private val DarkColorScheme = darkColorScheme(\n" + "    primary = Color(0xFF64B5F6),\n" + "    onPrimary = Color.Black,\n" + "    background = Color(0xFF121212),\n" + "    onBackground = Color.White,\n" + "    surface = Color(0xFF1E1E1E),\n" + "    onSurface = Color.White\n" + ")"
    ) {

    },
    Example(
        title = "6\uFE0F⃣ Bonus Tip: Use for Icons and Buttons Too",
        description = "Just like Text, you can also theme icons:",
        code = "Icon(\n" + "    imageVector = Icons.Default.Favorite,\n" + "    contentDescription = \"Favorite\",\n" + "    tint = MaterialTheme.colorScheme.primary\n" + ")\n" + "Button(\n" + "    onClick = {},\n" + "    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)\n" + ") {\n" + "    Text(\"Click\", color = MaterialTheme.colorScheme.onPrimary)\n" + "}"
    ) {

    },
    Example(
        title = "7\uFE0F⃣ Summary Notes",
        description = "To make text colors adapt automatically to dark and light themes,\n" + "use colors from MaterialTheme.colorScheme instead of hardcoded Color.Black or Color.White",
        code = ""
    ) {

    },
)