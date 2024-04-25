package com.sazcode.movierating

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.sazcode.movierating.presentation.ui.DetailScreen
import com.sazcode.movierating.presentation.ui.VisualizeContentScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreen.MoviesScreen.route) {
        composable(route = AppScreen.MoviesScreen.route, arguments = listOf(
            navArgument(name = "movieId") {
                type = NavType.StringType
            }
        )) {
            VisualizeContentScreen(navController = navController)
        }
        composable(route = AppScreen.MovieDetailScreen.route+"/{movieId}") {
            DetailScreen(navController, it.arguments?.getString("movieId"))
        }
    }

}
