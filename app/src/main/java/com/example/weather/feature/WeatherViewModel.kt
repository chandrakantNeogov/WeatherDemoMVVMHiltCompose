package com.example.weather.feature

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather.model.toWeatherUiModel
import com.example.weather.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(private val weatherRepository: WeatherRepository) : ViewModel() {
    private val _uiState = MutableStateFlow<WeatherUiState>(WeatherUiState.Empty)
    val uiState : StateFlow<WeatherUiState> = _uiState

    init {
        fetchWeather()
    }
    private fun fetchWeather(cityName: String = "New Delhi") {
        _uiState.value = WeatherUiState.Loading
        viewModelScope.launch {
            try {
                val weatherApiResponse = weatherRepository.fetchWeather(cityName)
                _uiState.value = WeatherUiState.Success(weatherApiResponse.toWeatherUiModel())
            } catch (e: Exception) {
                Log.e("WeatherViewModel", "Error fetching weather", e)
                _uiState.value = WeatherUiState.Error(e.message ?: "An error occurred")
            }
        }
    }
}