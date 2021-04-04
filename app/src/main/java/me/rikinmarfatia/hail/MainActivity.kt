package me.rikinmarfatia.hail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.mvrx.compose.collectAsState
import com.airbnb.mvrx.compose.mavericksViewModel
import me.rikinmarfatia.hail.ui.theme.HailTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HailTheme {
                Surface(color = MaterialTheme.colors.background) {
                    WeatherFeed()
                }
            }
        }
    }
}

@Composable
fun WeatherFeed() {
    val viewModel: WeatherViewModel = mavericksViewModel()
    val state by viewModel.collectAsState { it.feed }

    WeatherFeed(state)
}

@Composable
fun WeatherFeed(state: List<WeatherState>) {
    LazyColumn(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.spacedBy(8.dp)) {
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
            .height(100.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(state.date)
        Text(state.low.toString())
        Text(state.high.toString())
    }
}

@Preview(showBackground = true)
@Composable
fun WeatherFeedPreview() {
    HailTheme(darkTheme = true) {
        Surface {
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