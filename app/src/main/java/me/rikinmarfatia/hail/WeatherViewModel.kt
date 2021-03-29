package me.rikinmarfatia.hail

import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.MavericksViewModel
import kotlinx.coroutines.launch

data class WeatherFeedState(
    val feed: List<WeatherState> = listOf(WeatherState())
): MavericksState

data class WeatherState(
    val date: String = "2021-03-28",
    val low: Int = 60,
    val high: Int = 80
)

class WeatherViewModel(
    weatherFeedState: WeatherFeedState = WeatherFeedState()
) : MavericksViewModel<WeatherFeedState>(weatherFeedState) {

    val weatherRepository = WeatherRepository()

    init {
        viewModelScope.launch {
            val weatherResponse = weatherRepository.weather()
            setState {
               toWeatherFeedState(weatherResponse)
            }
        }
    }

    private fun toWeatherFeedState(weatherWrapper: WeatherWrapper): WeatherFeedState {
        return WeatherFeedState(
            feed = weatherWrapper.consolidatedWeather.map(this::toWeatherState)
        )
    }

    private fun toWeatherState(weather: Weather): WeatherState {
        return WeatherState(
            date = weather.applicableDate,
            low = weather.minTemp.toInt(),
            high = weather.maxTemp.toInt()
        )
    }
}