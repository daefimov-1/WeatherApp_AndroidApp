package com.example.weatherapp_.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun WeatherForOneDay(
    modifier: Modifier = Modifier,
    numberOfDay: Int,
    state: WeatherState,
) {
    state.weatherInfo?.weatherDataPerDay?.get(numberOfDay)?.let { weatherData ->
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = weatherData[18].time.dayOfWeek.toString(),
                color = Color.White
            )
            Image(
                painter = painterResource(id = weatherData[18].weatherType.iconRes),
                contentDescription = null,
                modifier = Modifier
                    .width(40.dp)
                    .height(50.dp)
            )
            Text(
                text = "${weatherData[18].temperatureCelsius}°C",
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "${weatherData[6].temperatureCelsius}°C",
                color = Color.Gray,
                fontWeight = FontWeight.Bold
            )
        }
    }
}