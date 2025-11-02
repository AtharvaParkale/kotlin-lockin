package com.example.kotlinlockin.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.kotlinlockin.presentation.screens.NavigationScreenOne
import com.example.kotlinlockin.presentation.screens.NavigationScreenTwo

@Composable
fun NavigationStack() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.NavScreenOne.route) {
        composable(route = Screen.NavScreenOne.route) {
            NavigationScreenOne(navController = navController)
        }
        composable(
            route = Screen.NavScreenTwo.route + "?text={text}", arguments = listOf(
                navArgument("text") {
                    type = NavType.StringType
                    nullable = true
                })
        ) {
            NavigationScreenTwo(text = it.arguments?.getString("text"))
        }
    }
}