package com.example.weather.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather.BuildConfig
import com.example.weather.data.remote.RetrofitInstance
import kotlinx.coroutines.launch

data class WeatherUiState(
    val city: String = "",
    val temperature: Double? = null,
    val description: String = "",
    val isLoading: Boolean = false,
    val error: String? = null
)

class WeatherViewModel : ViewModel() {

    var uiState by mutableStateOf(WeatherUiState())
        private set

    fun updateCity(city: String) {
        uiState = uiState.copy(city = city)
    }

    fun fetchWeather() {
        viewModelScope.launch {
            uiState = uiState.copy(isLoading = true, error = null)

            try {
                val response = RetrofitInstance.api.getWeather(
                    uiState.city,
                    BuildConfig.WEATHER_API_KEY
                )

                uiState = uiState.copy(
                    temperature = response.main.temp,
                    description = response.weather.firstOrNull()?.description ?: "",
                    isLoading = false
                )

            } catch (e: Exception) {
                uiState = uiState.copy(
                    isLoading = false,
                    error = "Failed to load weather"
                )
            }
        }
    }
}