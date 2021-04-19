package com.example.weatherfeedpreview

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.weatherfeedfeature.WeatherFeed
import com.example.weatherrepo.FakeWeatherRepository
import com.example.weatherfeedfeature.WeatherViewModel
import me.rikinmarfatia.hail.ui.theme.HailTheme

@Preview
@Composable
fun WeatherFeedPreview() {
    HailTheme {
        val viewModel = WeatherViewModel(
            weatherRepository = FakeWeatherRepository()
        )

        val state by viewModel.feedStates().collectAsState()

        WeatherFeed(state = state)
    }
}