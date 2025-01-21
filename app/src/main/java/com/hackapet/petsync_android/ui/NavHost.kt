package com.hackapet.petsync_android.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.hackapet.petsync_android.ui.screens.details.DetailsScreen
import com.hackapet.petsync_android.ui.screens.home.HomeScreen
import com.hackapet.petsync_android.ui.screens.list.ListScreen


@Composable
fun AppNavigator() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(onNavigateToDetail = { petId ->
                navController.navigate("details/${petId}")
            },
                onNavigateToCreate = {
                    navController.navigate("details/-1")
                },
                onNavigateToList = { navController.navigate("list") }
            )
        }
        composable("list") {
            ListScreen(onNavigateToDetail = { petId ->
                navController.navigate("details/${petId}")
            })
        }
        composable("details/{petId}",
            arguments = listOf(navArgument("petId") { type = NavType.LongType })
        ) {
            val petId =
                remember { navController.currentBackStackEntry?.arguments?.getLong("petId") ?: -1L }

            DetailsScreen(petId = petId, onBack = {
                navController.popBackStack()
            })
        }
    }
}