package com.example.kotlinlockin.common.data


import com.example.kotlinlockin.common.data.entity.Example

fun getDesignSystemExamples(): List<Example> = listOf(
    Example(
        title = "Creating a Reusable Design System in Jetpack Compose",
        description = "A Design System is a structured collection of:\n" + "\t•\tColors\n" + "\t•\tTypography\n" + "\t•\tShapes\n" + "\t•\tSpacing\n" + "\t•\tComponents (Buttons, Cards, Text styles, etc.)\n" + "\t•\tTheme configuration (Light/Dark)\n" + "\t•\tUtility modifiers\n" + "\n" + "Its goal is to ensure consistent UI across the entire app.\n" + "\n" + "Jetpack Compose makes it very easy to build your own reusable design system.",
        code = "",
    ) {

    },
    Example(
        title = "1\uFE0F⃣ Why Create a Design System?",
        description = "\t•\tEnsures consistent UI across screens\n" + "\t•\tReuse styles + components\n" + "\t•\tFaster development\n" + "\t•\tEasy theme switching\n" + "\t•\tEasy brand redesign\n" + "\t•\tOne place to change look & feel",
        code = "",
    ) {

    },
    Example(
        title = "3\uFE0F⃣ File Structure of a Design System",
        description = "This gives you a proper component library inside your app.",
        code = "ui/\n" + "  theme/\n" + "    Color.kt\n" + "    Type.kt\n" + "    Shape.kt\n" + "    Dimens.kt\n" + "    Theme.kt\n" + "  components/\n" + "    AppButton.kt\n" + "    AppCard.kt\n" + "    AppTextField.kt\n" + "    AppTopBar.kt",
    ) {

    },
    Example(
        title = "4\uFE0F⃣ Colors.kt",
        description = "Also define light and dark color schemes here.",
        code = "val Primary = Color(0xFF1565C0)\n" + "val Secondary = Color(0xFF64B5F6)\n" + "val BackgroundLight = Color(0xFFFFFFFF)\n" + "val BackgroundDark = Color(0xFF121212)\n" + "val ErrorRed = Color(0xFFD32F2F)",
    ) {

    },
    Example(
        title = "5\uFE0F⃣ Typography.kt",
        description = "",
        code = "val AppTypography = Typography(\n" + "    headlineLarge = TextStyle(fontSize = 30.sp, fontWeight = Bold),\n" + "    titleLarge = TextStyle(fontSize = 22.sp, fontWeight = SemiBold),\n" + "    bodyLarge = TextStyle(fontSize = 16.sp, fontWeight = Normal)\n" + ")",
    ) {

    },
    Example(
        title = "6\uFE0F⃣ Shapes.kt",
        description = "",
        code = "val AppShapes = Shapes(\n" + "    small = RoundedCornerShape(6.dp),\n" + "    medium = RoundedCornerShape(12.dp),\n" + "    large = RoundedCornerShape(20.dp)\n" + ")",
    ) {

    },
    Example(
        title = "7\uFE0F⃣ Dimens.kt (Spacing & Sizes)",
        description = "",
        code = "object AppDimens {\n" + "    val Small = 4.dp\n" + "    val Medium = 8.dp\n" + "    val Large = 16.dp\n" + "    val ExtraLarge = 24.dp\n" + "}",
    ) {

    },
    Example(
        title = "8\uFE0F⃣ Create Reusable Components",
        description = "",
        code = "@Composable\n" + "fun AppButton(text: String, onClick: () -> Unit) {\n" + "    Button(\n" + "        onClick = onClick,\n" + "        shape = MaterialTheme.shapes.medium,\n" + "        colors = ButtonDefaults.buttonColors(\n" + "            MaterialTheme.colorScheme.primary\n" + "        ),\n" + "        modifier = Modifier.fillMaxWidth()\n" + "    ) {\n" + "        Text(\n" + "            text,\n" + "            style = MaterialTheme.typography.titleMedium,\n" + "            color = MaterialTheme.colorScheme.onPrimary\n" + "        )\n" + "    }\n" + "}",
    ) {

    },
    Example(
        title = "Example: AppCard.kt",
        description = "",
        code = "@Composable\n" + "fun AppCard(content: @Composable () -> Unit) {\n" + "    Card(\n" + "        shape = MaterialTheme.shapes.medium,\n" + "        elevation = CardDefaults.cardElevation(4.dp),\n" + "        colors = CardDefaults.cardColors(\n" + "            containerColor = MaterialTheme.colorScheme.surface\n" + "        )\n" + "    ) {\n" + "        Box(modifier = Modifier.padding(AppDimens.Medium)) {\n" + "            content()\n" + "        }\n" + "    }\n" + "}",
    ) {

    },
    Example(
        title = "Example: AppTextField.kt",
        description = "",
        code = "@Composable\n" + "fun AppTextField(value: String, onValueChange: (String) -> Unit, hint: String) {\n" + "    OutlinedTextField(\n" + "        value = value,\n" + "        onValueChange = onValueChange,\n" + "        label = { Text(hint) },\n" + "        textStyle = MaterialTheme.typography.bodyLarge\n" + "    )\n" + "}",
    ) {

    },
    Example(
        title = "Theme.kt (Central Brain of the Design System)",
        description = "",
        code = "@Composable\n" + "fun AppTheme(\n" + "    darkTheme: Boolean = isSystemInDarkTheme(),\n" + "    dynamicColor: Boolean = true,\n" + "    content: @Composable () -> Unit\n" + ") {\n" + "    val context = LocalContext.current\n" + "\n" + "    val colorScheme = when {\n" + "        dynamicColor && darkTheme -> dynamicDarkColorScheme(context)\n" + "        dynamicColor && !darkTheme -> dynamicLightColorScheme(context)\n" + "        darkTheme -> DarkColorScheme\n" + "        else -> LightColorScheme\n" + "    }\n" + "\n" + "    MaterialTheme(\n" + "        colorScheme = colorScheme,\n" + "        typography = AppTypography,\n" + "        shapes = AppShapes,\n" + "        content = content\n" + "    )\n" + "}",
    ) {

    },
    Example(
        title = " Use the Design System Everywhere",
        description = "",
        code = "setContent {\n" + "    AppTheme {\n" + "        MyAppNavigation()\n" + "    }\n" + "}",
    ) {

    },
    Example(
        title = "",
        description = "",
        code = "",
    ) {

    },
)