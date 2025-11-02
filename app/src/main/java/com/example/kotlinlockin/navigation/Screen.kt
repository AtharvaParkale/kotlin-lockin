package com.example.kotlinlockin.navigation

sealed class Screen(val route: String) {
    object NavScreenOne : Screen("nav_screen_one")
    object NavScreenTwo : Screen("nav_screen_two")
}