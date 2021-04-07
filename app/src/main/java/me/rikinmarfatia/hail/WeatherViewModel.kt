package me.rikinmarfatia.hail

import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.MavericksViewModel
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

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
            date = extractCurrentDay(weather.applicableDate),
            low = weather.minTemp.toFarenheight().toInt(),
            high = weather.maxTemp.toFarenheight().toInt()
        )
    }

    private fun Double.toFarenheight(): Double {
        return (this * 9/5.0) + 32
    }

    private fun extractCurrentDay(date: String): String {
        val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.US)
        val currentDate = formatter.parse(date)
        val calendar = Calendar.getInstance().apply {
            time = currentDate!!
        }
        return calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.US)!!
    }
}