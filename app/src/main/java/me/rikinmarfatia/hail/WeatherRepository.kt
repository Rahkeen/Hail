package me.rikinmarfatia.hail

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@JsonClass(generateAdapter = true)
data class WeatherWrapper(
    @Json(name = "consolidated_weather") val consolidatedWeather: List<Weather>,
)

@JsonClass(generateAdapter = true)
data class Weather(
    @Json(name = "min_temp") val minTemp: Double,
    @Json(name = "max_temp") val maxTemp: Double,
    @Json(name = "the_temp") val theTemp: Double,
    @Json(name = "applicable_date") val applicableDate: String
)

interface WeatherRepository {
    suspend fun weather(): WeatherWrapper
}

fun WeatherRepository(live: WeatherRepository = RealWeatherRepository()) = live

class RealWeatherRepository : WeatherRepository {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://www.metaweather.com/api/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    private val weatherService = retrofit.create(WeatherService::class.java)

    override suspend fun weather(): WeatherWrapper {
        return weatherService.getWeather()
    }
}

class FakeWeatherRepository : WeatherRepository {
    override suspend fun weather(): WeatherWrapper {
       return WeatherWrapper(
           consolidatedWeather = listOf(
               Weather(
                   minTemp = 15.0,
                   maxTemp = 20.0,
                   theTemp = 16.0,
                   applicableDate = "2021-03-28"
               ),
               Weather(
                   minTemp = 15.0,
                   maxTemp = 20.0,
                   theTemp = 16.0,
                   applicableDate = "2021-03-29"
               ),
               Weather(
                   minTemp = 15.0,
                   maxTemp = 20.0,
                   theTemp = 16.0,
                   applicableDate = "2021-03-30"
               )
           )
       )
    }
}