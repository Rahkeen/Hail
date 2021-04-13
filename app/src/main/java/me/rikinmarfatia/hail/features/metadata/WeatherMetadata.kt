package me.rikinmarfatia.hail.features.metadata

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.rikinmarfatia.hail.features.weather.presentation.WeatherType
import me.rikinmarfatia.hail.ui.WeatherIndicator
import me.rikinmarfatia.hail.ui.theme.HailTheme
import me.rikinmarfatia.hail.ui.theme.backgroundBlue

@Composable
fun WeatherMetadata(date: String?) {
    Column(
        modifier = Modifier
            .background(color = backgroundBlue)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Header
        Text(
            text = "San Francisco, CA",
            style = MaterialTheme.typography.body1,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(16.dp))

        WeatherIndicator(type = WeatherType.Clear, size = 200.dp)
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Clear",
            style = MaterialTheme.typography.body1,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "56°F",
            style = MaterialTheme.typography.h1,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(16.dp))


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Wind",
                style = MaterialTheme.typography.body1,
                color = Color.White,
            )
            Text(
                text = "9.3mph",
                style = MaterialTheme.typography.body1,
                color = Color.White,
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Humidity",
                style = MaterialTheme.typography.body1,
                color = Color.White,
            )
            Text(
                text = "10%",
                style = MaterialTheme.typography.body1,
                color = Color.White,
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Confidence",
                style = MaterialTheme.typography.body1,
                color = Color.White,
            )
            Text(
                text = "80%",
                style = MaterialTheme.typography.body1,
                color = Color.White,
            )
        }
    }
}

@Preview
@Composable
fun WeatherMetadataPreview() {
    HailTheme {
        WeatherMetadata(null)
    }
}