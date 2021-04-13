package me.rikinmarfatia.hail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import me.rikinmarfatia.hail.features.metadata.WeatherMetadata
import me.rikinmarfatia.hail.features.weather.presentation.WeatherFeed
import me.rikinmarfatia.hail.ui.theme.HailTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HailTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "feed") {
                    composable("feed") { WeatherFeed(navController) }
                    composable("metadata/{date}") { entry ->
                       WeatherMetadata(entry.arguments?.getString("date"))
                    }
                }
            }
        }
    }
}
