package me.rikinmarfatia.hail

import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.MavericksViewModel
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

enum class WeatherType {
    Clear,
    HeavyCloud,
    LightCloud,
    Rainy
}

data class WeatherFeedState(
    val feed: List<WeatherState> = emptyList()
): MavericksState

data class WeatherState(
    val date: String = "2021-03-28",
    val curr: Int = 70,
    val low: Int = 60,
    val high: Int = 80,
    val type: WeatherType = WeatherType.Clear
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
            curr = weather.theTemp.toFarenheight().toInt(),
            low = weather.minTemp.toFarenheight().toInt(),
            high = weather.maxTemp.toFarenheight().toInt(),
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