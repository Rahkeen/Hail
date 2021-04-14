package me.rikinmarfatia.hail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import me.rikinmarfatia.hail.features.metadata.WeatherMetadata
import me.rikinmarfatia.hail.features.weather.data.FakeWeatherRepository
import me.rikinmarfatia.hail.features.weather.data.WeatherRepository
import me.rikinmarfatia.hail.features.weather.presentation.WeatherFeed
import me.rikinmarfatia.hail.features.weather.presentation.WeatherFeedState
import me.rikinmarfatia.hail.features.weather.presentation.WeatherViewModel
import me.rikinmarfatia.hail.features.weather.presentation.WeatherViewModelFactory
import me.rikinmarfatia.hail.ui.theme.HailTheme

@ExperimentalAnimationApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HailTheme {
                val navController = rememberNavController()
                val weatherViewModel: WeatherViewModel = viewModel(
                    factory = WeatherViewModelFactory(
                        initialState = WeatherFeedState(),
                        weatherRepository = WeatherRepository()
                    )
                )
                NavHost(navController = navController, startDestination = "feed") {
                    composable("feed") { WeatherFeed(weatherViewModel, navController) }
                    composable("metadata") {
                        WeatherMetadata(weatherViewModel)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun HailPlayground() {
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
