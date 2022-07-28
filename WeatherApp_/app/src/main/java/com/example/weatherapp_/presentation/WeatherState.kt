package com.example.weatherapp_.presentation

import com.example.weatherapp_.domain.weather.WeatherInfo

data class WeatherState (
    val weatherInfo: WeatherInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)