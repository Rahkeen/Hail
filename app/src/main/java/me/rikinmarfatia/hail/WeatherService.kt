package me.rikinmarfatia.hail

import retrofit2.http.GET
import retrofit2.http.Path

const val SAN_FRANCISCO_WOEID = 2487956
const val LONDON_WOEID = 44418

interface WeatherService {
    @GET("location/{woeid}")
    suspend fun getWeather(@Path("woeid") woeid: Int = SAN_FRANCISCO_WOEID): WeatherFeed
}