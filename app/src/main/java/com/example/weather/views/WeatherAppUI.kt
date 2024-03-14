package com.example.weather.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.weather.R
import com.example.weather.feature.WeatherUiState
import com.example.weather.feature.WeatherViewModel
import com.example.weather.ui.theme.backgroundColor

@Composable
fun WeatherAppUI(weatherUiModel: WeatherViewModel = viewModel()) {
    Column(modifier = Modifier.background(backgroundColor)) {
        when (val state = weatherUiModel.uiState.collectAsState().value) {
            is WeatherUiState.Empty -> {
                Text(text = stringResource(id = R.string.no_data_available))
            }

            is WeatherUiState.Loading -> Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                WeatherLoadingAnimation()
            }

            is WeatherUiState.Success -> {
                WeatherLoadedScreen(data = state.data)
            }

            is WeatherUiState.Error -> {
                ErrorDialog(errorMessage = state.message)
            }

        }
    }
}