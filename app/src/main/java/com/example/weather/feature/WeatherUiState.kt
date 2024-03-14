package com.example.weather.feature
import com.example.weather.model.WeatherUiModel

sealed class WeatherUiState {
    data object Empty : WeatherUiState()
    data object Loading : WeatherUiState()
    data class Success(val data: WeatherUiModel) : WeatherUiState()
    data class Error(val message: String) : WeatherUiState()
}