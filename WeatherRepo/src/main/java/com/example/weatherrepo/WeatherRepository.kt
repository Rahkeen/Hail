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

//val buildTimeHelper = ubyteArrayOf(
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
//)