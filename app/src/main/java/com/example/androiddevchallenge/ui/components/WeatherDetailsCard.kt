package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class WeatherDetails(
    val type: String,
    val value: String
)

val sampleWeatherDetails = listOf(
    WeatherDetails("Wind", "33 m/h"),
    WeatherDetails("Humidity", "23%"),
    WeatherDetails("Visibility", "11 km"),
)

@Composable
fun WeatherDetailsCard(modifier: Modifier) {
    Surface(
        modifier,
        shape = MaterialTheme.shapes.medium
    ) {
        Row(Modifier.padding(20.dp), horizontalArrangement = Arrangement.SpaceBetween) {
            sampleWeatherDetails.forEach { (type, value) ->
                Column {
                    Text(text = type)
                    Text(text = value)
                }
            }
        }
    }
}
