package me.rikinmarfatia.hail.features.weather.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WeatherFeed(
    @Json(name = "consolidated_weather") val consolidatedWeather: List<Weather>,
    @Json(name = "title") val title: String
)

@JsonClass(generateAdapter = true)
data class Weather(
    @Json(name = "min_temp") val minTemp: Double,
    @Json(name = "max_temp") val maxTemp: Double,
    @Json(name = "the_temp") val theTemp: Double,
    @Json(name = "applicable_date") val applicableDate: String,
    @Json(name = "weather_state_abbr") val weatherStateAbbr: String
)
