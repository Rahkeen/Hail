package me.rikinmarfatia.hail.features.weather.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import me.rikinmarfatia.hail.features.weather.data.Weather
import me.rikinmarfatia.hail.features.weather.data.WeatherFeed
import me.rikinmarfatia.hail.features.weather.data.WeatherRepository
import kotlin.math.roundToInt

class WeatherViewModel(
    initialState: WeatherFeedState = WeatherFeedState(),
    private val weatherRepository: WeatherRepository = WeatherRepository()
) : ViewModel() {

    private val feedStates = MutableStateFlow(initialState)
    private var metadataState = mutableStateOf(WeatherState())

    init {
        viewModelScope.launch {
            try {
                val weather = weatherRepository.getWeather()
                feedStates.value = weather.toWeatherFeedState()
            } catch (e: Exception) {
                feedStates.value = WeatherFeedState(title = "No Internet 😢")
            }
        }
    }

    private fun WeatherFeed.toWeatherFeedState(): WeatherFeedState {
        return WeatherFeedState(
            title = title,
            feed = consolidatedWeather.map { it.toWeatherState() }
        )
    }

    private fun Weather.toWeatherState(): WeatherState {
        return WeatherState(
            date = applicableDate,
            curr = theTemp.toFahrenheit(),
            low = minTemp.toFahrenheit(),
            high = maxTemp.toFahrenheit(),
            type = weatherStateAbbr.toWeatherType(),
            wind = windSpeed.roundToInt(),
            humidity = humidity,
            confidence = predictability
        )
    }

    private fun String.toWeatherType(): WeatherType {
        return when (this) {
            "c" -> WeatherType.Clear
            "hc" -> WeatherType.HeavyCloud
            "lc" -> WeatherType.LightCloud
            else -> WeatherType.Rainy
        }
    }

    private fun Double.toFahrenheit(): Int {
        return ((this * 9 / 5.0) + 32).roundToInt()
    }

    fun feedStates(): StateFlow<WeatherFeedState> {
        return feedStates
    }

    fun metadataState(): State<WeatherState> {
        return metadataState
    }

    fun feedItemSelected(state: WeatherState) {
        metadataState.value = state
    }
}

@Suppress("UNCHECKED_CAST")
class WeatherViewModelFactory(
    private val initialState: WeatherFeedState,
    private val weatherRepository: WeatherRepository = WeatherRepository()
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return WeatherViewModel(initialState, weatherRepository) as T
    }

}