package com.example.kotlinlockin.common.data

import com.example.kotlinlockin.common.data.entity.Example

fun getThemeExamples(): List<Example> = listOf(
    Example(
        title = "1\uFE0F⃣ Why Support Dark and Light Themes",
        description = "\t•\tEnhances user experience and accessibility\n" + "\t•\tSaves battery on OLED screens\n" + "\t•\tMatches the device’s system appearance automatically\n" + "\t•\tCompose makes it super easy using isSystemInDarkTheme()",
        code = "",
    ) {},
    Example(
        title = "2\uFE0F⃣ Create Two Color Schemes",
        description = "In ui/theme/Color.kt define your color palette:",
        code = "package com.example.kotlinlockin.ui.theme\n" + "import androidx.compose.ui.graphics.Color\n" + "\n" + "val BluePrimary = Color(0xFF1565C0)\n" + "val BlueSecondary = Color(0xFF64B5F6)\n" + "val DarkBackground = Color(0xFF121212)\n" + "val LightBackground = Color(0xFFFFFFFF)\n" + "val ErrorRed = Color(0xFFD32F2F)",
    ) {},
    Example(
        title = "Now in Theme.kt, define both light and dark color schemes.",
        description = "✅ Explanation:\n" + "\t•\tlightColorScheme() and darkColorScheme() are built-in helpers.\n" + "\t•\tonPrimary, onBackground, etc. define text/icon colors placed on those surfaces.",
        code = "private val LightColorScheme = lightColorScheme(\n" + "    primary = BluePrimary,\n" + "    secondary = BlueSecondary,\n" + "    background = LightBackground,\n" + "    surface = Color(0xFFF8F8F8),\n" + "    onPrimary = Color.White,\n" + "    onBackground = Color.Black,\n" + "    onSurface = Color.Black,\n" + "    error = ErrorRed\n" + ")\n" + "\n" + "private val DarkColorScheme = darkColorScheme(\n" + "    primary = BlueSecondary,\n" + "    secondary = BluePrimary,\n" + "    background = DarkBackground,\n" + "    surface = Color(0xFF1E1E1E),\n" + "    onPrimary = Color.Black,\n" + "    onBackground = Color.White,\n" + "    onSurface = Color.White,\n" + "    error = ErrorRed\n" + ")",
    ) {},
    Example(
        title = "3\uFE0F⃣ Detect System Theme Automatically",
        description = "Compose provides:" + "\nIt returns true if the user’s device is in dark mode.",
        code = "isSystemInDarkTheme()",
    ) {

    },
    Example(
        title = "4\uFE0F⃣ Create a Custom Theme Function",
        description = "Inside Theme.kt combine everything:" + "\n✅ Now your app automatically switches between themes based on system setting. ",
        code = "@Composable\n" + "fun KotlinLockInTheme(\n" + "    darkTheme: Boolean = isSystemInDarkTheme(),\n" + "    content: @Composable () -> Unit\n" + ") {\n" + "    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme\n" + "\n" + "    MaterialTheme(\n" + "        colorScheme = colorScheme,\n" + "        typography = Typography,\n" + "        shapes = Shapes,\n" + "        content = content\n" + "    )\n" + "}",
    ) {

    },
    Example(
        title = "5\uFE0F⃣ (Optional) Add Dynamic Color Support (Android 12 +)",
        description = "For Android 12 and above, use wallpaper-based dynamic colors:" + "\n✅ Dynamic color makes your app instantly match user wallpaper tones.",
        code = "val dynamicColor = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S\n" + "val colorScheme = when {\n" + "    dynamicColor && darkTheme -> dynamicDarkColorScheme(LocalContext.current)\n" + "    dynamicColor && !darkTheme -> dynamicLightColorScheme(LocalContext.current)\n" + "    darkTheme -> DarkColorScheme\n" + "    else -> LightColorScheme\n" + "}",
    ) {

    },
    Example(
        title = "6\uFE0F⃣ Apply Theme in MainActivity",
        description = "✅ Everything inside KotlinLockInTheme automatically uses the correct color scheme.",
        code = "class MainActivity : ComponentActivity() {\n" + "    override fun onCreate(savedInstanceState: Bundle?) {\n" + "        super.onCreate(savedInstanceState)\n" + "        setContent {\n" + "            KotlinLockInTheme {\n" + "                Surface(\n" + "                    modifier = Modifier.fillMaxSize(),\n" + "                    color = MaterialTheme.colorScheme.background\n" + "                ) {\n" + "                    ThemedScreen()\n" + "                }\n" + "            }\n" + "        }\n" + "    }\n" + "}",
    ) {

    },
    Example(
        title = "7\uFE0F⃣ Example UI That Reacts to Theme",
        description = "✅ This screen automatically updates colors when switching themes.",
        code = "@Composable\n" + "fun ThemedScreen() {\n" + "    Column(\n" + "        modifier = Modifier\n" + "            .fillMaxSize()\n" + "            .background(MaterialTheme.colorScheme.background)\n" + "            .padding(16.dp)\n" + "    ) {\n" + "        Text(\n" + "            text = \"Dark/Light Theme Example\",\n" + "            color = MaterialTheme.colorScheme.onBackground,\n" + "            style = MaterialTheme.typography.titleLarge\n" + "        )\n" + "\n" + "        Spacer(modifier = Modifier.height(16.dp))\n" + "\n" + "        Button(\n" + "            onClick = {},\n" + "            colors = ButtonDefaults.buttonColors(\n" + "                containerColor = MaterialTheme.colorScheme.primary\n" + "            )\n" + "        ) {\n" + "            Text(\"Primary Button\", color = MaterialTheme.colorScheme.onPrimary)\n" + "        }\n" + "    }\n" + "}",
    ) {

    },
    Example(
        title = "8\uFE0F⃣ Optional: Manual Theme Toggle",
        description = "You can also give users a button or switch to manually change theme." + "\n ✅ The theme changes instantly when user toggles the switch.",
        code = "@Composable\n" + "fun ThemeToggleDemo() {\n" + "    var isDarkTheme by remember { mutableStateOf(false) }\n" + "\n" + "    KotlinLockInTheme(darkTheme = isDarkTheme) {\n" + "        Column(modifier = Modifier.padding(16.dp)) {\n" + "            Switch(\n" + "                checked = isDarkTheme,\n" + "                onCheckedChange = { isDarkTheme = it }\n" + "            )\n" + "            Text(if (isDarkTheme) \"Dark Mode\" else \"Light Mode\")\n" + "        }\n" + "    }\n" + "}",
    ) {

    },
    Example(
        title = "9\uFE0F⃣ Summary Notes",
        description = "Jetpack Compose makes dark / light theme support effortless — define two color schemes, detect system theme, and wrap your UI in a MaterialTheme.",
        code = "",
    ) {},
)