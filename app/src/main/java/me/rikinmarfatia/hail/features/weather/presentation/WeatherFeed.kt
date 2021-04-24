package me.rikinmarfatia.hail.features.weather.presentation

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
import androidx.compose.foundation.layout.wrapContentSize
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.weatherrepo.FakeWeatherRepository
import me.rikinmarfatia.hail.ui.WeatherIndicator
import me.rikinmarfatia.hail.ui.theme.HailTheme
import me.rikinmarfatia.hail.ui.theme.backgroundBlue
import me.rikinmarfatia.hail.ui.theme.cellBlue

@Composable
fun WeatherFeed(weatherViewModel: WeatherViewModel, navController: NavController) {
    val state by weatherViewModel.feedStates().collectAsState()

    WeatherFeed(
        state = state,
        action = weatherViewModel::feedItemSelected,
        navigate = navController::navigate
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
fun WeatherFeedPreview() {
    HailTheme(darkTheme = true) {
        val viewModel = WeatherViewModel(
            weatherRepository = FakeWeatherRepository()
        )

        val state by viewModel.feedStates().collectAsState()

        WeatherFeed(state = state)
    }
}
