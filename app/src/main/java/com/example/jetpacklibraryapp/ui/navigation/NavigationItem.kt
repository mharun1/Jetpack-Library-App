package com.example.jetpacklibraryapp.ui.navigation

import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationItem(
    val title: String,
    val defaultIcon: ImageVector,
    val selectedIcon: ImageVector,
    val screen: Screen
)