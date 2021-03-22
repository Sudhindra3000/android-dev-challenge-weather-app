/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.constants.StringConstants.DEGREE
import com.example.androiddevchallenge.models.WeatherType

data class HourlyForecastData(
    val weatherType: WeatherType,
    val time: Int,
    val am: Boolean,
    val temperature: Int
)

val sampleHourlyData = listOf(
    HourlyForecastData(
        WeatherType.SUNNY,
        -1,
        true,
        87
    ),
    HourlyForecastData(
        WeatherType.SUNNY,
        10,
        true,
        89
    ),
    HourlyForecastData(
        WeatherType.CLOUDY,
        11,
        true,
        87
    ),
    HourlyForecastData(
        WeatherType.SUNNY,
        12,
        false,
        91
    ),
    HourlyForecastData(
        WeatherType.CLOUDY,
        1,
        false,
        93
    ),
    HourlyForecastData(
        WeatherType.RAINY,
        2,
        false,
        93
    ),
    HourlyForecastData(
        WeatherType.RAINY,
        3,
        false,
        91
    ),
    HourlyForecastData(
        WeatherType.SUNNY,
        4,
        false,
        89
    ),
    HourlyForecastData(
        WeatherType.SUNNY,
        5,
        false,
        87
    ),
    HourlyForecastData(
        WeatherType.SUNNY,
        6,
        false,
        86
    ),
    HourlyForecastData(
        WeatherType.STORMY,
        7,
        false,
        84
    ),
    HourlyForecastData(
        WeatherType.STORMY,
        8,
        false,
        82
    ),
    HourlyForecastData(
        WeatherType.STORMY,
        9,
        false,
        80
    ),
    HourlyForecastData(
        WeatherType.CLOUDY,
        10,
        false,
        78
    ),
    HourlyForecastData(
        WeatherType.CLOUDY,
        11,
        false,
        80
    ),
    HourlyForecastData(
        WeatherType.CLOUDY,
        12,
        true,
        77
    ),
)

@Composable
fun HourlyForecastCard(modifier: Modifier) {
    Surface(
        modifier,
        shape = MaterialTheme.shapes.medium
    ) {
        Column(Modifier.padding(20.dp)) {
            Text(text = "Hourly Forecast", fontWeight = FontWeight.Bold)
            Spacer(Modifier.size(20.dp))
            Row(
                Modifier.horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.spacedBy(40.dp)
            ) {
                sampleHourlyData.forEach {
                    HourlyForecastItem(it)
                }
            }
        }
    }
}

@Composable
fun HourlyForecastItem(data: HourlyForecastData) {
    val (type, time, am, temperature) = data
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = if (time != -1) "$time${if (am) "AM" else "PM"}" else "Now")
        Icon(
            painter = painterResource(
                when (type) {
                    WeatherType.SUNNY -> R.drawable.ic_sunny
                    WeatherType.RAINY -> R.drawable.ic_rainy
                    WeatherType.CLOUDY -> R.drawable.ic_cloudy
                    WeatherType.STORMY -> R.drawable.ic_stormy
                }
            ),
            contentDescription = "Weather Type"
        )
        Text(text = "$temperature$DEGREE")
    }
}
