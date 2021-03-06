package com.example.weatherfeedfeature

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import me.rikinmarfatia.hail.features.weather.presentation.WeatherFeedState
import me.rikinmarfatia.hail.features.weather.presentation.WeatherState
import me.rikinmarfatia.hail.ui.theme.backgroundBlue
import me.rikinmarfatia.hail.ui.theme.cellBlue

@Composable
fun WeatherFeed(weatherViewModel: WeatherViewModel, navigate: (String) -> Unit) {
    val state by weatherViewModel.feedStates().collectAsState()

    WeatherFeed(
        state = state,
        action = weatherViewModel::feedItemSelected,
        navigate = navigate
    )
}

@Composable
fun WeatherFeed(
    state: WeatherFeedState,
    action: (WeatherState) -> Unit = {},
    navigate: (String) -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = backgroundBlue)
    ) {
        LocationHeader(location = state.title)
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(items = state.feed) { state ->
                WeatherRow(
                    state = state,
                    action = action,
                    navigate = navigate
                )
            }
        }
    }
}

@Composable
fun WeatherRow(
    state: WeatherState,
    action: (WeatherState) -> Unit,
    navigate: (String) -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(horizontal = 16.dp)
            .shadow(4.dp, shape = RoundedCornerShape(size = 8.dp))
            .background(color = cellBlue, shape = RoundedCornerShape(size = 8.dp))
            .clickable {
                action(state)
                navigate("metadata")
            },
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = state.currentDay,
            modifier = Modifier
                .weight(1F, true)
                .wrapContentHeight(),
            style = MaterialTheme.typography.body1,
            textAlign = TextAlign.Center
        )
        WeatherIndicator(modifier = Modifier.weight(1F, true), type = state.type)
        WeatherNumberTile(
            modifier = Modifier.weight(1F, true),
            weatherValue = state.low,
            annotation = "Low"
        )
        WeatherNumberTile(
            modifier = Modifier.weight(1F, true),
            weatherValue = state.high,
            annotation = "High"
        )
    }
}

