package com.example.weatherapp_.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun WeatherForWeekCard(
    state: WeatherState,
    backgroundColor: Color,
    modifier: Modifier = Modifier    
) {
    val numberOfDaysList = listOf<Int>(0, 1, 2, 3, 4, 5, 6)
    Card(
        backgroundColor = backgroundColor,
        shape = RoundedCornerShape(10.dp),
        modifier = modifier
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "Weather for week",
                modifier = Modifier.align(Alignment.End),
                color = Color.White)
            Spacer(modifier = Modifier.height(16.dp))
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(numberOfDaysList){ num ->
                    WeatherForOneDay(numberOfDay = num, state = state)
                }
            }
        }
    }
}