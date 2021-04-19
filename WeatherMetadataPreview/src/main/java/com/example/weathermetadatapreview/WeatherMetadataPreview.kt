package com.example.weathermetadatapreview

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.weathermetadatafeature.WeatherMetadata
import com.example.weatherrepo.FakeWeatherRepository
import com.example.weatherfeedfeature.WeatherViewModel
import me.rikinmarfatia.hail.ui.theme.HailTheme

@Preview
@Composable
fun WeatherMetadataPreview() {
    HailTheme {
        val viewModel = WeatherViewModel(weatherRepository = FakeWeatherRepository())
        WeatherMetadata(viewModel)
    }
}