package com.example.kotlinlockin.common.data

import com.example.kotlinlockin.common.data.entity.Example

fun getNavigationCompose(): List<Example> = listOf(
    Example(
        title = "1\uFE0F⃣ Add the Dependency",
        description = "Inside app/build.gradle → dependencies { }`, add:",
        code = "implementation(\"androidx.navigation:navigation-compose:2.7.3\")",
    ) {},
    Example(
        title = "2\uFE0F⃣ Sync the Project",
        description = "Android Studio →\n" + "File → Sync Project with Gradle Files",
        code = "",
    ) {},
    Example(
        title = "3\uFE0F⃣ Imports Needed in Code",
        description = "",
        code = "import androidx.navigation.NavHostController\n" + "import androidx.navigation.compose.NavHost\n" + "import androidx.navigation.compose.composable\n" + "import androidx.navigation.compose.rememberNavController",
    ) {},
    Example(
        title = "4\uFE0F⃣ Basic Setup Example",
        description = "",
        code = "@Composable\n" + "fun AppNavigation() {\n" + "    val navController = rememberNavController()\n" + "\n" + "    NavHost(navController = navController, startDestination = \"home\") {\n" + "        composable(\"home\") { HomeScreen(navController) }\n" + "        composable(\"profile\") { ProfileScreen(navController) }\n" + "    }\n" + "}",
    ) {},
    Example(
        title = "Summary Notes (Copy-Paste)",
        description = "\t•\tAdd dependency: androidx.navigation:navigation-compose\n" + "\t•\tSync Gradle\n" + "\t•\tUse rememberNavController()\n" + "\t•\tWrap screens inside NavHost\n" + "\t•\tUse composable(route) to define screens",
        code = "",
    ) {}
)