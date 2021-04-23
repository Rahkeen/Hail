package com.example.weatherrepolive

import com.example.weatherrepo.WeatherFeed
import com.example.weatherrepo.WeatherRepository
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

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

