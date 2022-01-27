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

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
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
    val animatedSurface by animateColorAsState(targetValue = MaterialTheme.colors.surface)
    Surface(
        modifier,
        color = animatedSurface,
        shape = MaterialTheme.shapes.medium
    ) {
        Row(Modifier.padding(20.dp), horizontalArrangement = Arrangement.SpaceBetween) {
            sampleWeatherDetails.forEach { (type, value) ->
                Column {
                    Text(text = type, fontWeight = FontWeight.Bold)
                    Spacer(Modifier.size(8.dp))
                    Text(text = value)
                }
            }
        }
    }
}
