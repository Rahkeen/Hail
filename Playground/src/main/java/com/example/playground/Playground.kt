package com.example.playground

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weatherfeedfeature.WeatherFeed
import com.example.weatherfeedfeature.WeatherViewModel
import com.example.weathermetadatafeature.WeatherMetadata
import com.example.weatherrepo.FakeWeatherRepository
import me.rikinmarfatia.hail.ui.theme.HailTheme

@Preview
@Composable
fun Playground() {
    HailTheme {
        val navController = rememberNavController()
        val weatherViewModel = WeatherViewModel(
            weatherRepository = FakeWeatherRepository()
        )
        NavHost(navController = navController, startDestination = "feed") {
            composable("feed") { WeatherFeed(weatherViewModel, navController) }
            composable("metadata") {
                WeatherMetadata(weatherViewModel)
            }
        }
    }
}