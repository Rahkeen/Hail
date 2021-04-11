package me.rikinmarfatia.hail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import me.rikinmarfatia.hail.features.weather.presentation.WeatherFeed
import me.rikinmarfatia.hail.ui.theme.HailTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HailTheme {
                WeatherFeed()
            }
        }
    }
}
