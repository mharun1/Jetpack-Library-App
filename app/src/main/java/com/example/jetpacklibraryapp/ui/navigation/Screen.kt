package com.example.jetpacklibraryapp.ui.navigation

sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object Attendances : Screen("attendances")
    data object Leave : Screen("leave")
    data object Profile : Screen("profile")
}