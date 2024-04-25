package com.sazcode.movierating

sealed class AppScreen(val route: String) {
    object MoviesScreen: AppScreen("movies_screen")
    object MovieDetailScreen: AppScreen("detail_movies_screen")
}