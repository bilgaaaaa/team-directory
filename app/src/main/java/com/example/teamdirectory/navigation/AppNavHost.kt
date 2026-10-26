package com.example.teamdirectory.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.teamdirectory.ui.detail.UserDetailScreen
import com.example.teamdirectory.ui.users.UsersScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = UsersRoute,
        modifier = modifier
    ) {
        composable<UsersRoute> {
            UsersScreen(
                onUserClick = { id ->
                    navController.navigate(UserDetailRoute(id))
                }
            )
        }
        composable<UserDetailRoute> { backStackEntry ->
            val route = backStackEntry.toRoute<UserDetailRoute>()
            UserDetailScreen(
                id = route.id,
                onBackClick = {
                    navController.navigateUp()
                }
            )
        }
    }
}
