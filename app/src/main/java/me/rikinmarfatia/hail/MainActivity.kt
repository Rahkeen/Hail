package me.rikinmarfatia.hail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.mvrx.compose.collectAsState
import me.rikinmarfatia.hail.ui.theme.HailTheme
import me.rikinmarfatia.hail.ui.theme.backgroundBlue
import me.rikinmarfatia.hail.ui.theme.cellBlue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HailTheme {
                Surface(color = backgroundBlue) {
                    WeatherFeed()
                }
            }
        }
    }
}

@Composable
fun WeatherFeed() {
    val viewModel = remember { WeatherViewModel() }
    val state by viewModel.collectAsState { it.feed }

    WeatherFeed(state)
}

@Composable
fun WeatherFeed(state: List<WeatherState>) {
    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(items = state) { state ->
            WeatherRow(state = state)
        }
    }
}

@Composable
fun WeatherRow(state: WeatherState) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(horizontal = 8.dp)
            .shadow(4.dp, shape = RoundedCornerShape(size = 8.dp))
            .background(color = cellBlue, shape = RoundedCornerShape(size = 8.dp)),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = state.date,
            modifier = Modifier
                .weight(1F, true)
                .wrapContentHeight(),
            style = MaterialTheme.typography.body1,
            textAlign = TextAlign.Center
        )
        Icon(imageVector = Icons.Outlined.Star, contentDescription = "", modifier = Modifier.weight(1F, true))
        Text(
            text = state.low.toString() + "°",
            modifier = Modifier
                .weight(1F, true)
                .wrapContentHeight(),
            style = MaterialTheme.typography.body1,
            textAlign = TextAlign.Center
        )
        Text(
            text = state.high.toString() + "°",
            modifier = Modifier
                .weight(1F, true)
                .wrapContentHeight(),
            style = MaterialTheme.typography.body1,
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
fun WeatherFeedPreview() {
    HailTheme(darkTheme = true) {
        Surface(color = backgroundBlue) {
            val viewModel = remember {
                WeatherViewModel(
                    weatherRepository = WeatherRepository(live = FakeWeatherRepository())
                )
            }
            val state by viewModel.collectAsState { it.feed }

            WeatherFeed(state = state)
        }
    }
}