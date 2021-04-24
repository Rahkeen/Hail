package com.example.weatherfeedfeature

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

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

@Composable
fun WeatherNumberTile(
    modifier: Modifier = Modifier,
    weatherValue: Int,
    annotation: String
) {
    Column(
        modifier = modifier then Modifier.wrapContentSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "$weatherValue", style = MaterialTheme.typography.body1)
        Text(text = annotation, style = MaterialTheme.typography.caption)
    }
}

@Composable
fun LocationHeader(location: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(all = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = location,
            style = MaterialTheme.typography.h2,
            color = Color.White
        )
    }
}

@Preview
@Composable
fun WeatherIndicatorPreview() {
    WeatherIndicator(type = WeatherType.Clear)
}

@Preview
@Composable
fun WeatherNumberTilePreview() {
    WeatherNumberTile(weatherValue = 100, annotation = "High")
}

@Preview
@Composable
fun LocationHeaderPreview() {
    LocationHeader(location = "PreviewVille")
}
