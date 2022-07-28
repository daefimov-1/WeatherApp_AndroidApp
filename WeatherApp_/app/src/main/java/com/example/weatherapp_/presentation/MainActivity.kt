package com.example.weatherapp_.presentation

import android.Manifest
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.weatherapp_.presentation.ui.theme.DarkBlue
import com.example.weatherapp_.presentation.ui.theme.DeepBlue
import com.example.weatherapp_.presentation.ui.theme.WeatherAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: WeatherViewModel by viewModels()
    private lateinit var permissionLauncher: ActivityResultLauncher<Array<String>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        permissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) {
            viewModel.loadWeatherInfo()
        }
        permissionLauncher.launch(arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ))
        setContent {
            WeatherAppTheme {
                Log.e("STATE", viewModel.state.toString())
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(DarkBlue)
                        .verticalScroll(rememberScrollState())
                ) {
                    WeatherCard(
                        state = viewModel.state,
                        backgroundColor = DeepBlue
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    WeatherForEachHour(state = viewModel.state)
                    Spacer(modifier = Modifier.height(16.dp))
                    WeatherForTomorrow(state = viewModel.state)
                    Spacer(modifier = Modifier.height(16.dp))
                    WeatherForWeekCard(
                        state = viewModel.state,
                        backgroundColor = DeepBlue
                    )
                }
            }
        }
    }
}