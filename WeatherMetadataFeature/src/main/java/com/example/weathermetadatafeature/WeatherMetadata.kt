package com.example.weathermetadatafeature

import android.util.Log
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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.weatherfeedfeature.WeatherViewModel
import com.example.weatherfeedfeature.WeatherIndicator
import me.rikinmarfatia.hail.ui.theme.backgroundBlue

@Composable
fun WeatherMetadata(weatherViewModel: WeatherViewModel) {
    val metadataState by weatherViewModel.metadataState()

    Log.i("WeatherMetadata", metadataState.currentDay)

    Column(
        modifier = Modifier
            .background(color = backgroundBlue)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Header
        Text(
            text = metadataState.currentDay,
            style = MaterialTheme.typography.body1,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(16.dp))

        WeatherIndicator(type = metadataState.type, size = 200.dp)
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = metadataState.type.name,
            style = MaterialTheme.typography.body1,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "${metadataState.curr}°F",
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
                text = "${metadataState.wind}mph",
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
                text = "${metadataState.humidity}%",
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
                text = "${metadataState.confidence}%",
                style = MaterialTheme.typography.body1,
                color = Color.White,
            )
        }
    }
}

