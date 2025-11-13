package com.example.kotlinlockin.common.data

import com.example.kotlinlockin.common.data.entity.Example

fun getMaterialThemeExamples(): List<Example> = listOf(
    Example(
        title = "1\uFE0F⃣ What is Material Theme in Jetpack Compose",
        code = "",
        description = "Material Theme defines the overall look and feel of your app — colors, typography (fonts), and shapes.\n" + "It provides a consistent, modern UI system across your entire app using Material Design principles.\n" + "\n" + "Jetpack Compose uses Material 3 (androidx.compose.material3) which automatically adapts to light/dark mode and dynamic colors"
    ) {

    },
    Example(
        title = "2\uFE0F⃣ Structure of Material Theme",
        code = "",
        description = "A Material Theme in Compose has three main parts:\n" + "\t•\t\uD83C\uDFA8 ColorScheme — defines colors (primary, secondary, background, etc.)\n" + "\t•\t✍\uFE0F Typography — defines fonts, weights, and sizes\n" + "\t•\t\uD83D\uDD32 Shapes — defines corner roundness for components like Buttons, Cards"
    ) {

    },
    Example(
        title = "3\uFE0F⃣ Default Theme Setup (in every Compose project)",
        code = "ui/theme/Color.kt  \n" + "ui/theme/Type.kt  \n" + "ui/theme/Shape.kt  \n" + "ui/theme/Theme.kt",
        description = "When you create a new Compose project, it automatically creates:" + ""
    ) {

    },
    Example(
        title = "\uD83C\uDFA8 Color.kt",
        code = "val Purple80 = Color(0xFFD0BCFF)\n" + "val Purple40 = Color(0xFF6650a4)\n" + "val Pink80 = Color(0xFFEFB8C8)\n" + "val Pink40 = Color(0xFF7D5260)",
        description = "Defines color variables used across the app."
    ) {

    },
    Example(
        title = "Type.kt",
        code = "val Typography = Typography(\n" + "    bodyLarge = TextStyle(\n" + "        fontFamily = FontFamily.Default,\n" + "        fontWeight = FontWeight.Normal,\n" + "        fontSize = 16.sp\n" + "    ),\n" + "    titleLarge = TextStyle(\n" + "        fontFamily = FontFamily.Serif,\n" + "        fontWeight = FontWeight.Bold,\n" + "        fontSize = 22.sp\n" + "    )\n" + ")",
        description = "Defines your typography styles." + "\n✅ Used for Text composables automatically — you can override if needed."
    ) {

    },
    Example(
        title = "Shape.kt",
        code = "val Shapes = Shapes(\n" + "    small = RoundedCornerShape(4.dp),\n" + "    medium = RoundedCornerShape(8.dp),\n" + "    large = RoundedCornerShape(16.dp)\n" + ")",
        description = "Defines corner shapes for UI components." + "\n✅ Used automatically in Buttons, Cards, etc."
    ) {

    },
    Example(
        title = "Theme.kt",
        code = "@Composable\n" + "fun KotlinLockInTheme(\n" + "    darkTheme: Boolean = isSystemInDarkTheme(),\n" + "    content: @Composable () -> Unit\n" + ") {\n" + "    val colorScheme = if (darkTheme) darkColorScheme() else lightColorScheme()\n" + "\n" + "    MaterialTheme(\n" + "        colorScheme = colorScheme,\n" + "        typography = Typography,\n" + "        shapes = Shapes,\n" + "        content = content\n" + "    )\n" + "}",
        description = "Brings everything together:" + "\n ✅ Wrap your app in this theme → all composables inside use the same style automatically."
    ) {

    },
    Example(
        title = "4\uFE0F⃣ Using Theme in Your App",
        code = "setContent {\n" + "    KotlinLockInTheme {\n" + "        // All components here will use your theme\n" + "        Surface(\n" + "            modifier = Modifier.fillMaxSize(),\n" + "            color = MaterialTheme.colorScheme.background\n" + "        ) {\n" + "            Greeting(\"Compose Theme\")\n" + "        }\n" + "    }\n" + "}",
        description = "You apply your custom theme inside MainActivity:" + "\n ✅ Everything inside KotlinLockInTheme automatically gets colors, typography, and shapes defined in your theme."
    ) {

    },
    Example(
        title = "5\uFE0F⃣ Accessing Theme Values",
        code = "@Composable\n" + "fun ThemeUsageExample() {\n" + "    Column(modifier = Modifier.padding(16.dp)) {\n" + "        Text(\n" + "            \"Primary Color Text\",\n" + "            color = MaterialTheme.colorScheme.primary,\n" + "            style = MaterialTheme.typography.titleLarge\n" + "        )\n" + "        Spacer(modifier = Modifier.height(8.dp))\n" + "        Button(\n" + "            onClick = {},\n" + "            shape = MaterialTheme.shapes.medium\n" + "        ) {\n" + "            Text(\"Click Me\")\n" + "        }\n" + "    }\n" + "}",
        description = "You can access the theme properties anywhere in your composables:" + "\n ✅ Explanation:\n" + "\t•\tMaterialTheme.colorScheme.primary → access theme’s primary color\n" + "\t•\tMaterialTheme.typography.titleLarge → access text style\n" + "\t•\tMaterialTheme.shapes.medium → access standard corner shape"
    ) {

    },
    Example(
        title = "6\uFE0F⃣ Dark & Light Theme Handling",
        code = "isSystemInDarkTheme()" + "\n private val LightColors = lightColorScheme(\n" + "    primary = Color(0xFF1565C0),\n" + "    secondary = Color(0xFF81D4FA),\n" + "    background = Color(0xFFFDFDFD)\n" + ")\n" + "\n" + "private val DarkColors = darkColorScheme(\n" + "    primary = Color(0xFF90CAF9),\n" + "    secondary = Color(0xFF42A5F5),\n" + "    background = Color(0xFF121212)\n" + ")" + "\n" + "val colors = if (darkTheme) DarkColors else LightColors",
        description = "Compose supports automatic switching between light and dark themes using:" + "\n In your Theme.kt, define two color sets:"
    ) {

    },
    Example(
        title = "7\uFE0F⃣ Dynamic Color (Android 12+)",
        code = "val dynamicColor = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S\n" + "val colorScheme = when {\n" + "    dynamicColor && darkTheme -> dynamicDarkColorScheme(LocalContext.current)\n" + "    dynamicColor && !darkTheme -> dynamicLightColorScheme(LocalContext.current)\n" + "    darkTheme -> DarkColors\n" + "    else -> LightColors\n" + "}",
        description = "Material 3 supports Dynamic Colors — uses user’s wallpaper colors to theme your app." + "\n ✅ Dynamic theming makes your app look native and consistent across devices."
    ) {

    },
    Example(
        title = "8\uFE0F⃣ Summary Notes",
        code = "",
        description = "MaterialTheme in Jetpack Compose is the foundation of your app’s visual identity — defining how your app looks, feels, and adapts to light/dark modes automatically."
    ) {

    },
)