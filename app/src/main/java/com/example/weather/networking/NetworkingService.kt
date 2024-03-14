package com.example.weather.networking

import com.example.weather.di.AppModule
import com.example.weather.model.DetailWeatherApiRsponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkingService {

    @GET("current.json")
    suspend fun fetchWeather(
        @Query("q") cityName: String,
        @Query("key") aqi: String = AppModule.API_KEY,
    ): DetailWeatherApiRsponse

    @GET("forecast.json")
    suspend fun fetchDetailedForecast(
        @Query("q") cityName: String,
        @Query("days") days: Int = 7,
        @Query("key") key: String = AppModule.API_KEY,
        @Query("aqi") aqi: String = "yes",
        @Query("alerts") alerts: String = "yes"
    ): DetailWeatherApiRsponse

}