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
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.example.androiddevchallenge.models.WeatherType
import com.example.androiddevchallenge.ui.components.CurrentDayWeatherCard
import com.example.androiddevchallenge.ui.components.DailyForecastCard
import com.example.androiddevchallenge.ui.components.HourlyForecastCard
import com.example.androiddevchallenge.ui.components.WeatherDetailsCard
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.toPaddingValues

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            val currentDayWeatherType by viewModel.currentDayWeatherType.observeAsState(WeatherType.CLOUDY)
            MyTheme(currentDayWeatherType) {
                ProvideWindowInsets {
                    MyApp(currentDayWeatherType)
                }
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp(currentDayWeatherType: WeatherType) {
    Surface(color = MaterialTheme.colors.background) {
        Column(
            Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(LocalWindowInsets.current.systemBars.toPaddingValues())
                .padding(15.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CurrentDayWeatherCard(Modifier.fillMaxWidth(), currentDayWeatherType)
            WeatherDetailsCard(Modifier.fillMaxWidth())
            HourlyForecastCard(Modifier.fillMaxWidth())
            DailyForecastCard(Modifier.fillMaxWidth())
        }
    }
}
