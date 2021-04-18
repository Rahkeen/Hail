package com.example.weatherrepo

interface WeatherRepository {
    suspend fun getWeather(): WeatherFeed
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
                   weatherStateAbbr = "c",
                   windSpeed = 9.6,
                   humidity = 10,
                   predictability = 90,
               ),
               Weather(
                   minTemp = 15.0,
                   maxTemp = 20.0,
                   theTemp = 16.0,
                   applicableDate = "2021-03-29",
                   weatherStateAbbr = "hc",
                   windSpeed = 9.6,
                   humidity = 10,
                   predictability = 90,
               ),
               Weather(
                   minTemp = 15.0,
                   maxTemp = 20.0,
                   theTemp = 16.0,
                   applicableDate = "2021-03-30",
                   weatherStateAbbr = "r",
                   windSpeed = 9.6,
                   humidity = 10,
                   predictability = 90,
               ),
               Weather(
                   minTemp = 15.0,
                   maxTemp = 20.0,
                   theTemp = 16.0,
                   applicableDate = "2021-03-31",
                   weatherStateAbbr = "c",
                   windSpeed = 9.6,
                   humidity = 10,
                   predictability = 90,
               ),
               Weather(
                   minTemp = 15.0,
                   maxTemp = 20.0,
                   theTemp = 16.0,
                   applicableDate = "2021-04-01",
                   weatherStateAbbr = "hc",
                   windSpeed = 9.6,
                   humidity = 10,
                   predictability = 90,
               ),
               Weather(
                   minTemp = 15.0,
                   maxTemp = 20.0,
                   theTemp = 16.0,
                   applicableDate = "2021-04-02",
                   weatherStateAbbr = "r",
                   windSpeed = 9.6,
                   humidity = 10,
                   predictability = 90,
               ),
           ),
           title = "Off The Grid 🕵🏾‍♂️"
       )
    }
}
