package com.example.jetpacklibraryapp.ui.navigation

sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object Favorite : Screen("favorite")
    data object History : Screen("history")
    data object Profile : Screen("profile")
}