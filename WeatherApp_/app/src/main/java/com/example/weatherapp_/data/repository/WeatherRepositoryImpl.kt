package com.example.weatherapp_.data.repository

import com.example.weatherapp_.data.mappers.toWeatherInfo
import com.example.weatherapp_.data.remote.WeatherApi
import com.example.weatherapp_.domain.repository.WeatherRepository
import com.example.weatherapp_.domain.util.Resource
import com.example.weatherapp_.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(val api: WeatherApi) : WeatherRepository {
    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = api.getWeatherData(
                    lat = lat,
                    long = long
                ).toWeatherInfo())
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
}