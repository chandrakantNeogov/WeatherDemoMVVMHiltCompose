package com.example.weather.repository

import com.example.weather.model.DetailWeatherApiRsponse
import com.example.weather.networking.NetworkingService
import javax.inject.Inject

interface WeatherRepository {
    suspend fun fetchWeather(cityName : String): DetailWeatherApiRsponse
}

class WeatherRepositoryImpl @Inject constructor(
private val networkingService: NetworkingService) : WeatherRepository {
    override suspend fun fetchWeather(cityName: String): DetailWeatherApiRsponse = networkingService.fetchDetailedForecast(cityName)
}