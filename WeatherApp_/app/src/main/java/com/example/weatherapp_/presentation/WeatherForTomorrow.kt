package com.example.weatherapp_.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WeatherForTomorrow(
    state: WeatherState,
    modifier: Modifier = Modifier
){
    state.weatherInfo?.weatherDataPerDay?.get(1)?.let { data ->
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "Tomorrow",
                fontSize = 20.sp,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(20.dp))
            LazyRow {
                items(data) { weatherData ->
                    WeatherForOneHour(
                        weatherData = weatherData,
                        modifier = Modifier
                            .height(100.dp)
                            .padding(horizontal = 16.dp)
                    )
                }
            }
        }
    }

}