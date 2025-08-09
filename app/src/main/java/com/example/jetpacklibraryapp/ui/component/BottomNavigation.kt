package com.example.jetpacklibraryapp.ui.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.jetpacklibraryapp.R
import com.example.jetpacklibraryapp.ui.navigation.NavigationItem
import com.example.jetpacklibraryapp.ui.navigation.Screen

@Composable
fun BottomNavigation(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    var selectedItem by remember { mutableIntStateOf(0) }
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route

    NavigationBar(modifier = modifier) {
        val navigationItem = listOf(
            NavigationItem(
                title = "Home",
                defaultIcon = Icons.Outlined.Home,
                selectedIcon = Icons.Default.Home,
                screen = Screen.Home,
            ),
            NavigationItem(
                title = "Attendances",
                defaultIcon = ImageVector.vectorResource(R.drawable.outlined_attendance_icon),
                selectedIcon = ImageVector.vectorResource(R.drawable.baseline_attendance_icon),
                screen = Screen.Attendances,
            ),
            NavigationItem(
                title = "Leave",
                defaultIcon = ImageVector.vectorResource(R.drawable.outlined_leave_icon),
                selectedIcon = ImageVector.vectorResource(R.drawable.baseline_leave_icon),
                screen = Screen.Leave,
            ),
            NavigationItem(
                title = "Profile",
                defaultIcon = Icons.Outlined.Person,
                selectedIcon = Icons.Default.Person,
                screen = Screen.Profile,
            )
        )
        navigationItem.forEachIndexed { index, items ->
            NavigationBarItem(
                icon = {
                    Icon(
                        if (selectedItem == index) items.selectedIcon else items.defaultIcon,
                        contentDescription = items.title
                    )
                },
                label = { Text(items.title) },
                selected = currentRoute == items.screen.route,
                onClick = {
                    selectedItem = index
                    val startDestinationId = navController.graph.findStartDestination().id
                    navController.navigate(items.screen.route) {
                        popUpTo(startDestinationId) {
                            saveState = true
                        }
                        restoreState
                        launchSingleTop = true
                    }
                },
                alwaysShowLabel = false,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun BottomNavigationPreview() {
    BottomNavigation(rememberNavController())
}