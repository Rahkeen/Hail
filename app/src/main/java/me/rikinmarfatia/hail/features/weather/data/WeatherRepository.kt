package me.rikinmarfatia.hail.features.weather.data

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

interface WeatherRepository {
    suspend fun getWeather(): WeatherFeed
}

fun WeatherRepository(live: WeatherRepository = RealWeatherRepository()) = live

class RealWeatherRepository : WeatherRepository {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://www.metaweather.com/api/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    private val weatherService = retrofit.create(WeatherService::class.java)

    override suspend fun getWeather(): WeatherFeed {
        return weatherService.getWeather()
    }
}

class FakeWeatherRepository : WeatherRepository {
    override suspend fun getWeather(): WeatherFeed {
       return WeatherFeed(
           consolidatedWeather = listOf(
               Weather(
                   minTemp = 15.0,
                   maxTemp = 20.0,
                   theTemp = 16.0,
                   applicableDate = "2021-03-28",
                   weatherStateAbbr = "c"
               ),
               Weather(
                   minTemp = 15.0,
                   maxTemp = 20.0,
                   theTemp = 16.0,
                   applicableDate = "2021-03-29",
                   weatherStateAbbr = "hc"
               ),
               Weather(
                   minTemp = 15.0,
                   maxTemp = 20.0,
                   theTemp = 16.0,
                   applicableDate = "2021-03-30",
                   weatherStateAbbr = "r"
               ),
               Weather(
                   minTemp = 15.0,
                   maxTemp = 20.0,
                   theTemp = 16.0,
                   applicableDate = "2021-03-28",
                   weatherStateAbbr = "c"
               ),
               Weather(
                   minTemp = 15.0,
                   maxTemp = 20.0,
                   theTemp = 16.0,
                   applicableDate = "2021-03-29",
                   weatherStateAbbr = "hc"
               ),
               Weather(
                   minTemp = 15.0,
                   maxTemp = 20.0,
                   theTemp = 16.0,
                   applicableDate = "2021-03-30",
                   weatherStateAbbr = "r"
               ),
           ),
           title = "Rikin's Crib"
       )
    }
}

//val buildTimeHelper = ubyteArrayOf(
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X01u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X01u, 0XC0u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X60u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X30u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X18u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X0Cu, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X06u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X07u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X03u, 0X80u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X01u, 0XC0u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0XE0u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0XF0u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X78u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X3Cu, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X08u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X1Cu, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X08u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X1Eu, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X0Cu, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X0Fu, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X0Cu, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X07u,
//    0X80u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X0Cu, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X0Eu, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X1Eu, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X1Eu, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X1Eu, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X1Fu, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X1Fu, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X1Fu, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X3Fu, 0X80u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X3Fu, 0X80u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X3Fu, 0X80u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X3Fu, 0XC0u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X3Fu, 0XC0u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X3Fu, 0XE0u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X3Fu, 0XE0u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X7Fu, 0XF0u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X7Fu, 0XF0u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X7Fu, 0XF0u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X7Fu, 0XF0u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X7Fu, 0XE0u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X7Fu, 0XE0u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X7Fu, 0XC0u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X04u, 0X00u, 0X7Fu, 0XC0u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X20u,
//    0X02u, 0X00u, 0X7Fu, 0X80u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X30u, 0X03u, 0X00u, 0XFFu, 0X80u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X38u, 0X03u, 0X80u, 0XFFu, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X3Cu, 0X01u, 0XE0u, 0XFFu, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X1Eu, 0X01u, 0XF0u, 0XFEu, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X1Fu, 0X01u, 0XF8u,
//    0XFEu, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X1Fu, 0X80u, 0XFFu, 0XFEu, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X0Fu, 0XC0u, 0XFFu, 0XFCu, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X0Fu,
//    0XE0u, 0XFFu, 0XFCu, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X0Fu, 0XF0u, 0XFFu, 0XF8u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X07u, 0XF0u, 0XFFu, 0XF8u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X60u, 0X00u, 0X00u,
//    0X00u, 0X07u, 0XFFu, 0XFFu, 0XF8u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X38u, 0XC0u, 0X00u, 0X00u, 0X03u, 0XFFu, 0XFFu, 0XF0u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X3Fu, 0XC0u, 0X00u, 0X00u, 0X03u, 0XFFu, 0XFFu,
//    0XF0u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X1Fu,
//    0XC0u, 0X00u, 0X00u, 0X03u, 0XFFu, 0XFFu, 0XF0u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X1Fu, 0XE0u, 0X00u, 0X00u, 0X01u, 0XFFu, 0XFFu, 0XF0u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X0Fu, 0XE0u, 0X00u, 0X00u, 0X01u,
//    0XFFu, 0XFFu, 0XF0u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X07u, 0XE0u, 0X00u, 0X00u, 0X01u, 0XFFu, 0XFFu, 0XE0u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X07u, 0XE0u, 0X00u, 0X00u, 0X00u, 0XFFu, 0XFFu, 0XE0u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X03u, 0XF0u, 0X00u,
//    0X00u, 0X00u, 0XFFu, 0XFFu, 0XE0u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X03u, 0XF0u, 0X00u, 0X00u, 0X00u, 0XFFu, 0XFFu, 0XE0u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X01u, 0XF0u, 0X00u, 0X00u, 0X00u, 0XFFu, 0XFFu,
//    0XE0u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0XF8u, 0X00u, 0X00u, 0X1Fu, 0XFFu, 0XFFu, 0XE0u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0XF8u, 0X00u, 0X00u, 0X1Fu, 0XFFu, 0XFFu, 0XE0u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X7Cu, 0X00u, 0X00u, 0X0Fu,
//    0XFFu, 0XFFu, 0XF0u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X7Cu, 0X00u, 0X00u, 0X0Fu, 0XFFu, 0XFFu, 0XF0u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X3Cu, 0X00u, 0X00u, 0X07u, 0XFFu, 0XFFu, 0XF0u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X3Eu, 0X00u,
//    0X00u, 0X07u, 0XFFu, 0XFFu, 0XF8u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X1Eu, 0X00u, 0X00u, 0X03u, 0XFFu, 0XFFu, 0XF8u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X0Fu, 0X00u, 0X00u, 0X00u, 0XFFu, 0XFFu,
//    0XFCu, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X0Fu, 0X00u, 0X00u, 0X00u, 0X7Fu, 0XFFu, 0XFCu, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X07u, 0X80u, 0X00u, 0X00u, 0X7Fu, 0XFFu, 0XFEu, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X07u, 0X80u, 0X00u, 0X00u,
//    0X7Fu, 0XFFu, 0XFEu, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X03u, 0XC0u, 0X00u, 0X01u, 0XFFu, 0XFFu, 0XFFu, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X03u, 0XE0u, 0X00u, 0X07u, 0XFFu, 0XFFu, 0XFFu, 0X80u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X01u, 0XF0u,
//    0X00u, 0X07u, 0XFFu, 0XFFu, 0XFFu, 0XC0u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X01u, 0XF0u, 0X00u, 0X0Fu, 0XFFu, 0XFFu, 0XFFu, 0XC0u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0XF8u, 0X00u, 0X0Fu, 0XFFu, 0XFFu,
//    0XFFu, 0XE0u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0XFCu, 0X00u, 0X0Fu, 0XFFu, 0XFFu, 0XFFu, 0XF0u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0XFEu, 0X00u, 0X0Fu, 0XFFu, 0XFFu, 0XFFu, 0XF0u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0XFFu, 0X00u, 0X1Fu,
//    0XFFu, 0XFFu, 0XFFu, 0XF8u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X20u, 0XFFu, 0XC0u, 0X3Fu, 0XFFu, 0XFFu, 0XFFu, 0XF0u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X30u, 0XFFu, 0XE0u, 0XFFu, 0XFFu, 0XFFu, 0XFEu, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X3Fu, 0XFFu,
//    0XFFu, 0XFFu, 0XFFu, 0XFFu, 0XF0u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X7Fu, 0XFFu, 0XFFu, 0XFFu, 0XFFu, 0XFFu, 0XC0u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X03u, 0XFFu, 0XFFu, 0XFFu, 0XFFu, 0XFFu, 0XFFu,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X01u,
//    0XFFu, 0XFFu, 0XFFu, 0XFFu, 0XFFu, 0XFEu, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0XFFu, 0XFFu, 0XFFu, 0XFFu, 0XFFu, 0XFCu, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X7Fu, 0XFFu, 0XFFu, 0XFFu,
//    0XFFu, 0XF8u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X1Fu, 0XFFu, 0XFFu, 0XFFu, 0XFFu, 0XF8u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X07u, 0XFFu, 0XFFu, 0XFFu, 0XFFu, 0XF0u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0XFFu,
//    0XFFu, 0XFFu, 0XFFu, 0XE0u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X3Fu, 0XFFu, 0XFFu, 0XFFu, 0XE0u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X1Fu, 0XFFu, 0XFFu, 0XFFu, 0XC0u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X0Fu, 0XFFu, 0XFFu, 0XFFu, 0XC0u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X0Fu, 0XFFu, 0XFFu, 0XFFu, 0XC0u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X0Fu, 0XFFu, 0XFFu,
//    0XFFu, 0XC0u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X0Fu, 0XFFu, 0XFFu, 0XFFu, 0XC0u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0XFFu, 0XFFu, 0XFFu, 0XFFu, 0XE0u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X08u, 0X03u, 0XFFu,
//    0XFFu, 0XFFu, 0XFFu, 0XE0u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X0Fu, 0XFFu, 0XFFu, 0XFFu, 0XFFu, 0XFFu, 0XF0u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X0Fu, 0XFFu, 0XFFu, 0XFFu, 0XFFu, 0XFFu, 0XF8u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X01u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X01u, 0XC0u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X60u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X30u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X18u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X0Cu, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X06u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X07u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X03u, 0X80u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X01u, 0XC0u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0XE0u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0XF0u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X78u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X3Cu, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X08u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X1Cu, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X08u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X1Eu, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X0Cu, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X0Fu, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X0Cu, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X07u,
//    0X80u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X0Cu, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X0Eu, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X1Eu, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X1Eu, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X1Eu, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X1Fu, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X1Fu, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X1Fu, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X3Fu, 0X80u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X3Fu, 0X80u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X3Fu, 0X80u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X3Fu, 0XC0u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X3Fu, 0XC0u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X3Fu, 0XE0u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X3Fu, 0XE0u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X7Fu, 0XF0u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X7Fu, 0XF0u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X7Fu, 0XF0u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X7Fu, 0XF0u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X7Fu, 0XE0u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X7Fu, 0XE0u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X7Fu, 0XC0u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X04u, 0X00u, 0X7Fu, 0XC0u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X20u,
//    0X02u, 0X00u, 0X7Fu, 0X80u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X30u, 0X03u, 0X00u, 0XFFu, 0X80u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X38u, 0X03u, 0X80u, 0XFFu, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X3Cu, 0X01u, 0XE0u, 0XFFu, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X1Eu, 0X01u, 0XF0u, 0XFEu, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u,
//    0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X00u, 0X1Fu, 0X01u, 0XF8u,
//)