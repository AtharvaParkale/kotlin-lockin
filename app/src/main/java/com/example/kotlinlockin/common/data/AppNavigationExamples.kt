package com.example.kotlinlockin.common.data

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kotlinlockin.common.composables.TutorialScreen
import com.example.kotlinlockin.common.data.entity.Example

fun getAppNavigationExamples(): List<Example> = listOf(
    Example(
        title = "1\uFE0F⃣ What is NavController?",
        description = "NavController is an object that:\n" + "\t•\tControls where to go (navigate to screen)\n" + "\t•\tManages back stack\n" + "\t•\tKeeps track of current screen (destination)\n" + "\t•\tAllows popping back to previous screens\n" + "\n" + "Think of it like:\n" + "\n" + "The remote control of your app’s navigation.\n" + "\n" + "How to create it:",
        code = "val navController = rememberNavController()\nnavController.navigate(\"profile\")\nnavController.popBackStack()"
    ) {

    },

    Example(
        title = "2\uFE0F⃣ What is NavHost?",
        description = "NavHost is where you define all screens (routes) of your app.\n" + "\n" + "Think of it like:\n" + "\n" + "A map of all screens and how to reach them.\nInside NavHost:\n" + "\t•\tEach composable(route) = one screen\n" + "\t•\tYou specify which screen loads first using startDestination",
        code = "NavHost(\n" + "    navController = navController,\n" + "    startDestination = \"home\"\n" + ") {\n" + "    composable(\"home\") { HomeScreen(navController) }\n" + "    composable(\"profile\") { ProfileScreen(navController) }\n" + "}"
    ) {

    }, Example(
        title = "3\uFE0F⃣ How NavController & NavHost Work Together",
        description = "",
        code = "NavHost = Defines screens\n" + "NavController = Moves between screens\n@Composable\n" + "fun AppNavigation() {\n" + "    val navController = rememberNavController()\n" + "\n" + "    NavHost(\n" + "        navController = navController,\n" + "        startDestination = \"home\"\n" + "    ) {\n" + "        composable(\"home\") { HomeScreen(navController) }\n" + "        composable(\"profile\") { ProfileScreen(navController) }\n" + "    }\n" + "}"
    ) {

    }, Example(
        title = "4\uFE0F⃣ Example With Two Screens",
        description = "\uD83D\uDD39 Home Screen: A button to go to profile",
        code = "@Composable\n" + "fun HomeScreen(navController: NavController) {\n" + "    Button(onClick = { navController.navigate(\"profile\") }) {\n" + "        Text(\"Go To Profile\")\n" + "    }\n" + "}"
    ) {
        val navController = rememberNavController()

        Column {
            NavHost(
                navController = navController, startDestination = "screenOne"
            ) {
                composable("screenOne") { TutorialScreen(getThemeExamplesPartTwo()) }
                composable("screenTwo") { TutorialScreen(getMutableStateExamples()) }
            }
            Button(onClick = { navController.navigate("screenTwo") }) {
                Text("Go To screenTwo")
            }
        }
    }, Example(
        title = "\uD83D\uDD39 Profile Screen: A button to go back",
        description = "",
        code = "@Composable\n" + "fun ProfileScreen(navController: NavController) {\n" + "    Button(onClick = { navController.popBackStack() }) {\n" + "        Text(\"Go Back\")\n" + "    }\n" + "}"
    ) {

    }, Example(
        title = " 5\uFE0F⃣ Real-World Usage Pattern",
        description = "You normally call your navigation setup inside MainActivity:",
        code = "setContent {\n" + "    AppTheme {\n" + "        AppNavigation()\n" + "    }\n" + "}"
    ) {

    })