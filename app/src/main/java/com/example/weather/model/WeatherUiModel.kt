package com.example.weather.model

data class WeatherUiModel(
    val location: String = "",
    val temperature: String = "",
    val weatherCondition: String = "",
    val windSpeed: String = "",
    val pressure: String = "",
    val humidity: String = "",
    val feelsLike: String = "",
    val visibility: String = "",
    val uvIndex: Double? = 0.0,
    val cloudiness: String = "",
    val precipitation: String = "",
    val gust: String = "",
    var todayWeatherIcon : List<TodayWeatherIcon> = emptyList(),
    var forecastForeWeek : List<ForecastForeWeekItem> = emptyList()

)

data class TodayWeatherIcon(
    val time: String = "",
    val weatherIcon: String = ""
)
data class ForecastForeWeekItem(
    val date: String = "",
    val maxTemp: String = "",
    val minTemp: String = "",
    val dayTemp: String = "",
    val nightTemp: String = "",
    val weatherCondition: String = "",
    val weatherIcon: String = "",
    var weeklyWeatherIcon: List<WeeklyWeatherIcon> = emptyList()
)

data class WeeklyWeatherIcon(
    val description: String = ""
)