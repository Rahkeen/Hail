package me.rikinmarfatia.hail.features.weather.presentation

import com.airbnb.mvrx.MavericksViewModel
import kotlinx.coroutines.launch
import me.rikinmarfatia.hail.features.weather.data.Weather
import me.rikinmarfatia.hail.features.weather.data.WeatherFeed
import me.rikinmarfatia.hail.features.weather.data.WeatherRepository
import kotlin.math.roundToInt

class WeatherViewModel(
    initialState: WeatherFeedState = WeatherFeedState(),
    private val weatherRepository: WeatherRepository = WeatherRepository()
) : MavericksViewModel<WeatherFeedState>(initialState) {

    init {
        viewModelScope.launch {
            try {
                val weather = weatherRepository.getWeather()
                setState {
                    toWeatherFeedState(weather)
                }
            } catch (e: Exception) {
                setState {
                    WeatherFeedState(title = "Error")
                }
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
}