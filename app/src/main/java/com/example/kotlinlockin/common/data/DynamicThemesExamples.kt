package com.example.kotlinlockin.common.data

import com.example.kotlinlockin.common.data.entity.Example

fun getDynamicThemingExamples(): List<Example> = listOf(

    Example(
        title = "1\uFE0F⃣ What Dynamic Theme Actually Means",
        code = "",
        description = "On Android 12+, the system extracts colors from the user’s wallpaper\n" + "(using something called Monet color engine) and generates a unique color palette.\n" + "\n" + "Your app can use this system-generated palette instead of your own colors.\n" + "\n" + "So your app always matches the user’s phone theme."
    ) {},
    Example(
        title = "2\uFE0F⃣ How Dynamic Theme Works in Compose",
        code = "val colorScheme = if (dynamicColor && darkTheme) {\n" + "    dynamicDarkColorScheme(context)\n" + "} else if (dynamicColor && !darkTheme) {\n" + "    dynamicLightColorScheme(context)\n" + "} else {\n" + "    DarkColorScheme or LightColorScheme\n" + "}",
        description = "Compose gives two functions:\n" + "\t•\tdynamicLightColorScheme(context)\n" + "\t•\tdynamicDarkColorScheme(context)\n" + "\n" + "These fetch the Material You color palette generated from the system/wallpaper.\n"
    ) {},
    Example(
        title = "3\uFE0F⃣ When is Dynamic Theme Use",
        code = "",
        description = "Dynamic theme is used only when:\n" + "\t1.\tDevice is Android 12+\n" + "\t2.\tdynamicColor = true\n" + "\t3.\tYour theme calls dynamicLightColorScheme or dynamicDarkColorScheme\n" + "\n" + "If device < Android 12 → dynamic theme is ignored automatically."
    ) {},
    Example(
        title = "4\uFE0F⃣ Why Dynamic Theme Overrides Your Custom Colors",
        code = "",
        description = "If dynamic theme is ON:" + "\n dynamicDarkColorScheme(context)\n will override your custom DarkColorScheme." + "\n That’s why you changed: surface = Color(0xFF8E8D8D)\n" + "but your UI did not update.\n" + "\n" + "Dynamic theme replaced your surface color with wallpaper-based colors."
    ) {},
    Example(
        title = "5\uFE0F⃣ How to Disable Dynamic Theme",
        code = "val dynamicColor = false",
        description = "Now your custom colors will appear exactly as defined."
    ) {},
    Example(
        title = "6\uFE0F⃣ Why Dynamic Theme Is Useful",
        code = "",
        description = "\t•\tMakes your app match the phone wallpaper\n" + "\t•\tMakes your app feel native and integrated\n" + "\t•\tAutomatically adapts user’s light/dark mode\n" + "\t•\tZero effort styling — system gives you ready palettes"
    ) {},
    Example(
        title = "7\uFE0F⃣ Simple Example of Theme Setup With Dynamic Colors",
        code = "@Composable\n" + "fun MyAppTheme(\n" + "    darkTheme: Boolean = isSystemInDarkTheme(),\n" + "    dynamicColor: Boolean = true,\n" + "    content: @Composable () -> Unit\n" + ") {\n" + "    val context = LocalContext.current\n" + "    val colorScheme = when {\n" + "        dynamicColor && darkTheme -> dynamicDarkColorScheme(context)\n" + "        dynamicColor && !darkTheme -> dynamicLightColorScheme(context)\n" + "        darkTheme -> DarkColorScheme\n" + "        else -> LightColorScheme\n" + "    }\n" + "\n" + "    MaterialTheme(\n" + "        colorScheme = colorScheme,\n" + "        typography = Typography,\n" + "        shapes = Shapes,\n" + "        content = content\n" + "    )\n" + "}",
        description = ""
    ) {},
    Example(
        title = "8\uFE0F⃣ Summary Notes (Super Short)",
        code = "",
        description = "\t•\tDynamic theme = app colors extracted from user’s wallpaper.\n" + "\t•\tWorks only on Android 12+.\n" + "\t•\tUses dynamicLightColorScheme() and dynamicDarkColorScheme().\n" + "\t•\tAutomatically adapts to light/dark mode.\n" + "\t•\tOverrides your custom color scheme unless you set dynamicColor = false."
    ) {},

    )