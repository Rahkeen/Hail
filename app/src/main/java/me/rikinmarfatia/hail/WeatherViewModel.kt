package me.rikinmarfatia.hail

import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.MavericksViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

data class WeatherFeedState(
    val feed: List<WeatherState> = emptyList()
): MavericksState

data class WeatherState(
    val date: String = "2021-03-28",
    val low: Int = 60,
    val high: Int = 80
)

class WeatherViewModel(
    initialState: WeatherFeedState = WeatherFeedState(),
    private val weatherRepository: WeatherRepository = WeatherRepository()
) : MavericksViewModel<WeatherFeedState>(initialState) {

    init {
        viewModelScope.launch {
            val weather = weatherRepository.getWeather()
            setState {
                toWeatherFeedState(weather)
            }
        }
    }

    private fun toWeatherFeedState(weatherFeed: WeatherFeed): WeatherFeedState {
        return WeatherFeedState(
            feed = weatherFeed.consolidatedWeather.map(this::toWeatherState)
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