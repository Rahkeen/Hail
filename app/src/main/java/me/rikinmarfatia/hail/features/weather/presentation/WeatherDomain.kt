package me.rikinmarfatia.hail.features.weather.presentation

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
    val title: String = "",
    val feed: List<WeatherState> = emptyList()
)

data class WeatherState(
    val title: String = "",
    val date: String = "2021-03-28",
    val curr: Int = 70,
    val low: Int = 60,
    val high: Int = 80,
    val type: WeatherType = WeatherType.Clear,
    val wind: Int = 10,
    val humidity: Int = 10,
    val confidence: Int = 80,
) {
    val currentDay: String = extractCurrentDay(date)

    private fun extractCurrentDay(date: String): String {
        val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.US)
        val currentDate = formatter.parse(date)
        val calendar = Calendar.getInstance().apply {
            time = currentDate!!
        }
        return calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.US)!!
    }
}
