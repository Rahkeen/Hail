package me.rikinmarfatia.hail.features.weather.presentation

import com.airbnb.mvrx.MavericksState

enum class WeatherType {
    Clear,
    HeavyCloud,
    LightCloud,
    Rainy
}

data class WeatherFeedState(
    val title: String = "",
    val feed: List<WeatherState> = emptyList()
) : MavericksState

data class WeatherState(
    val date: String = "2021-03-28",
    val curr: Int = 70,
    val low: Int = 60,
    val high: Int = 80,
    val type: WeatherType = WeatherType.Clear
)
