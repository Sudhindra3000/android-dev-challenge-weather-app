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

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.constants.StringConstants
import com.example.androiddevchallenge.models.WeatherType

@Composable
fun CurrentDayWeatherInfo(
    modifier: Modifier,
    currentDayWeatherType: WeatherType
) {
    Column(
        modifier.padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(6.dp),
    ) {
        Crossfade(targetState = currentDayWeatherType) { state ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(6.dp),
            ) {
                Icon(
                    modifier = Modifier.size(200.dp),
                    painter = painterResource(
                        when (state) {
                            WeatherType.SUNNY -> R.drawable.ic_sunny
                            WeatherType.RAINY -> R.drawable.ic_rainy
                            WeatherType.CLOUDY -> R.drawable.ic_cloudy
                            WeatherType.STORMY -> R.drawable.ic_stormy
                        }
                    ),
                    contentDescription = "Current Day Weather Type"
                )
                Text(
                    text = state.toString(),
                    style = MaterialTheme.typography.caption.copy(fontWeight = FontWeight.Bold)
                )
            }
        }
        Spacer(Modifier.size(10.dp))
        Text(text = "84${StringConstants.DEGREE}", style = MaterialTheme.typography.h1)
    }
}
