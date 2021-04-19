package com.example.weatherfeedfeature

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import me.rikinmarfatia.hail.features.weather.presentation.WeatherType

@Composable
fun WeatherIndicator(type: WeatherType, modifier: Modifier = Modifier, size: Dp = 30.dp) {
    val startColor = when (type) {
        WeatherType.Clear -> Color.Yellow
        WeatherType.LightCloud, WeatherType.HeavyCloud -> Color.Gray
        WeatherType.Rainy -> Color.Blue
    }

    val endColor = when (type) {
        WeatherType.Clear, WeatherType.LightCloud -> Color.Red
        WeatherType.HeavyCloud -> Color.DarkGray
        WeatherType.Rainy -> Color.DarkGray
    }

    val display = when (type) {
        WeatherType.Clear -> "Clear"
        WeatherType.HeavyCloud -> "Cloudy"
        WeatherType.LightCloud -> "Cloudy"
        WeatherType.Rainy -> "Rainy"
    }

    Column(
        modifier = modifier then Modifier.wrapContentSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Canvas(modifier = Modifier.size(size)) {
            drawCircle(
                brush = Brush.linearGradient(
                    colors = listOf(startColor, endColor)
                )
            )
        }
    }
}

@Preview
@Composable
fun WeatherIndicatorPreview() {
    WeatherIndicator(type = WeatherType.Clear)
}
