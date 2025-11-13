package com.example.kotlinlockin.common.data

import com.example.kotlinlockin.common.data.entity.Example

fun getCustomisingColorExamples(): List<Example> = listOf(
    Example(
        title = "1\uFE0F⃣ Overview",
        description = "MaterialTheme in Jetpack Compose is built using 3 main design pillars you can customize:" + "\n (\uD83C\uDFA8 Colors ==" + "App color palette == " + "Color.kt\n)" + "\n Typography == " + "Text styles and font settings ==" + "Type.kt\n" + "Typography == " + "Text styles and font settings ==" + "Type.kt\n" + "\n These are combined inside your app’s Theme.kt to create a unified MaterialTheme.",
        code = ""
    ) {

    },
    Example(
        title = "2\uFE0F⃣ Customizing Colors",
        code = "// Color.kt\n" + "package com.example.kotlinlockin.ui.theme\n" + "\n" + "import androidx.compose.ui.graphics.Color\n" + "\n" + "val PrimaryBlue = Color(0xFF1565C0)\n" + "val SecondaryBlue = Color(0xFF81D4FA)\n" + "val BackgroundLight = Color(0xFFFDFDFD)\n" + "val BackgroundDark = Color(0xFF121212)\n" + "val ErrorRed = Color(0xFFD32F2F)",
        description = "You define your app’s color palette inside Color.kt." + "\n Then, use these colors inside your light and dark color schemes."
    ) {

    },
    Example(
        title = "Defining light and dark color schemes",
        code = "// Theme.kt\n" + "private val LightColorScheme = lightColorScheme(\n" + "    primary = PrimaryBlue,\n" + "    secondary = SecondaryBlue,\n" + "    background = BackgroundLight,\n" + "    error = ErrorRed\n" + ")\n" + "\n" + "private val DarkColorScheme = darkColorScheme(\n" + "    primary = SecondaryBlue,\n" + "    secondary = PrimaryBlue,\n" + "    background = BackgroundDark,\n" + "    error = ErrorRed\n" + ")",
        description = "✅ You can add more:\n" + "onPrimary, onBackground, surface, onSurface, etc."
    ) {

    },
    Example(
        title = "Applying in Theme",
        code = "@Composable\n" + "fun KotlinLockInTheme(\n" + "    darkTheme: Boolean = isSystemInDarkTheme(),\n" + "    content: @Composable () -> Unit\n" + ") {\n" + "    val colors = if (darkTheme) DarkColorScheme else LightColorScheme\n" + "\n" + "    MaterialTheme(\n" + "        colorScheme = colors,\n" + "        typography = Typography,\n" + "        shapes = Shapes,\n" + "        content = content\n" + "    )\n" + "}",
        description = ""
    ) {

    },
    Example(
        title = "Using colors in components",
        code = "Button(\n" + "    onClick = {},\n" + "    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)\n" + ") {\n" + "    Text(\"Custom Button\")\n" + "}",
        description = "✅ Note:\n" + "\t•\tAccess colors using MaterialTheme.colorScheme.<color>\n" + "\t•\tColors automatically switch for dark/light themes."
    ) {

    },
    Example(
        title = "3\uFE0F⃣ Customizing Typography",
        code = "// Type.kt\n" + "val AppTypography = Typography(\n" + "    bodyLarge = TextStyle(\n" + "        fontFamily = FontFamily.Serif,\n" + "        fontWeight = FontWeight.Normal,\n" + "        fontSize = 18.sp\n" + "    ),\n" + "    titleLarge = TextStyle(\n" + "        fontFamily = FontFamily.SansSerif,\n" + "        fontWeight = FontWeight.Bold,\n" + "        fontSize = 22.sp\n" + "    ),\n" + "    labelSmall = TextStyle(\n" + "        fontFamily = FontFamily.Monospace,\n" + "        fontWeight = FontWeight.Medium,\n" + "        fontSize = 12.sp\n" + "    )\n" + ")",
        description = "Typography controls your font family, size, and weight for different text styles.\n"
    ) {

    },
    Example(
        title = "Using typography in composables",
        code = "Text(\n" + "    text = \"Custom Typography Example\",\n" + "    style = MaterialTheme.typography.titleLarge,\n" + "    color = MaterialTheme.colorScheme.primary\n" + ")" + "\n\n val MyFontFamily = FontFamily(Font(R.font.poppins_regular)",
        description = "✅ Tips:\n" + "\t•\tUse custom fonts by placing .ttf or .otf in res/font/\n" + "\t•\tCreate font families using:"
    ) {

    },
    Example(
        title = "4\uFE0F⃣ Customizing Shapes",
        code = "// Shape.kt\n" + "val AppShapes = Shapes(\n" + "    small = RoundedCornerShape(4.dp),\n" + "    medium = RoundedCornerShape(10.dp),\n" + "    large = RoundedCornerShape(20.dp)\n" + ")",
        description = "Shapes define corner radius for UI components like buttons, cards, dialogs, etc."
    ) {

    },
    Example(
        title = "Using shapes in UI",
        code = "Button(\n" + "    onClick = {},\n" + "    shape = MaterialTheme.shapes.large\n" + ") {\n" + "    Text(\"Rounded Button\")\n" + "}",
        description = "✅ Note:\n" + "\t•\tCommonly used with Card, Surface, and Button\n" + "\t•\tYou can define sharp corners with CutCornerShape(8.dp)"
    ) {

    },
    Example(
        title = "5\uFE0F⃣ Putting It All Together",
        code = "@Composable\n" + "fun KotlinLockInTheme(\n" + "    darkTheme: Boolean = isSystemInDarkTheme(),\n" + "    content: @Composable () -> Unit\n" + ") {\n" + "    val colors = if (darkTheme) DarkColorScheme else LightColorScheme\n" + "\n" + "    MaterialTheme(\n" + "        colorScheme = colors,\n" + "        typography = AppTypography,\n" + "        shapes = AppShapes,\n" + "        content = content\n" + "    )\n" + "}",
        description = "In Theme.kt you combine everything:"
    ) {

    },
    Example(
        title = "✅ Wrap your entire UI in KotlinLockInTheme (inside MainActivity):",
        code = "setContent {\n" + "    KotlinLockInTheme {\n" + "        MyScreen()\n" + "    }\n" + "}",
        description = ""
    ) {

    },
    Example(
        title = "6\uFE0F⃣ Example – Themed Card",
        code = "@Composable\n" + "fun ThemedCardExample() {\n" + "    Card(\n" + "        modifier = Modifier\n" + "            .padding(16.dp)\n" + "            .fillMaxWidth(),\n" + "        shape = MaterialTheme.shapes.medium,\n" + "        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondary)\n" + "    ) {\n" + "        Column(modifier = Modifier.padding(16.dp)) {\n" + "            Text(\n" + "                text = \"Compose Theming\",\n" + "                style = MaterialTheme.typography.titleLarge,\n" + "                color = MaterialTheme.colorScheme.onSecondary\n" + "            )\n" + "            Text(\n" + "                text = \"Custom colors, typography, and shapes make your app unique!\",\n" + "                style = MaterialTheme.typography.bodyLarge\n" + "            )\n" + "        }\n" + "    }\n" + "}",
        description = "✅ Result:\n" + "This card adapts automatically to dark mode and uses your custom theme settings."
    ) {

    },

    )