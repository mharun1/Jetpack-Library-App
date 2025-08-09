package com.example.jetpacklibraryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpacklibraryapp.ui.component.BottomNavigation
import com.example.jetpacklibraryapp.ui.navigation.Screen
import com.example.jetpacklibraryapp.ui.screen.favorite.FavoriteScreen
import com.example.jetpacklibraryapp.ui.screen.history.HistoryScreen
import com.example.jetpacklibraryapp.ui.screen.home.HomeScreen
import com.example.jetpacklibraryapp.ui.screen.profile.ProfileScreen
import com.example.jetpacklibraryapp.ui.theme.JetpackLibraryAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackLibraryAppTheme {
                JetpackLibraryApp()
            }
        }
    }
}

@Composable
fun JetpackLibraryApp(
    modifier: Modifier = Modifier,
    navHostController: NavHostController = rememberNavController(),
) {
    Scaffold(
        bottomBar = {
            BottomNavigation(navHostController)
        },
        modifier = modifier.fillMaxSize()
    ) { innerPadding ->
        NavHost(
            navController = navHostController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen()
            }
            composable(Screen.Attendances.route) {
                FavoriteScreen()
            }
            composable(Screen.Leave.route) {
                HistoryScreen()
            }
            composable(Screen.Profile.route) {
                ProfileScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackLibraryAppTheme {
        JetpackLibraryApp()
    }
}