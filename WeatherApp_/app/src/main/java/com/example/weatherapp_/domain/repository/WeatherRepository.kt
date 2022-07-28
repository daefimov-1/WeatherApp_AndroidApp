package com.example.weatherapp_.domain.repository

import com.example.weatherapp_.domain.util.Resource
import com.example.weatherapp_.domain.weather.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo>
}