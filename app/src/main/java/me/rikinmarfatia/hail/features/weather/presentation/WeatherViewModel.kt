package me.rikinmarfatia.hail.features.weather.presentation

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

    private val states = MutableStateFlow(initialState)

    init {
        viewModelScope.launch {
            try {
                val weather = weatherRepository.getWeather()
                states.value = toWeatherFeedState(weather)
            } catch (e: Exception) {
                states.value = WeatherFeedState(title = "Error")
            }
        }
    }

    private fun toWeatherFeedState(weatherFeed: WeatherFeed): WeatherFeedState {
        return WeatherFeedState(
            title = weatherFeed.title,
            feed = weatherFeed.consolidatedWeather.map(this::toWeatherState)
        )
    }

    private fun toWeatherState(weather: Weather): WeatherState {
        return WeatherState(
            date = weather.applicableDate,
            curr = weather.theTemp.toFahrenheit(),
            low = weather.minTemp.toFahrenheit(),
            high = weather.maxTemp.toFahrenheit(),
            type = weather.weatherStateAbbr.toWeatherType()
        )
    }

    private fun String.toWeatherType(): WeatherType {
        return when(this) {
             "c" -> WeatherType.Clear
            "hc" -> WeatherType.HeavyCloud
            "lc" -> WeatherType.LightCloud
            else -> WeatherType.Rainy
        }
    }

    private fun Double.toFahrenheit(): Int {
        return ((this * 9/5.0) + 32).roundToInt()
    }

    fun states(): StateFlow<WeatherFeedState> {
        return states
    }
}

@Suppress("UNCHECKED_CAST")
class WeatherViewModelFactory(
    private val initialState: WeatherFeedState,
    private val weatherRepository: WeatherRepository = WeatherRepository()
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return WeatherViewModel(initialState, weatherRepository) as T
    }

}