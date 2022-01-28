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
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.core.view.WindowCompat
import com.example.androiddevchallenge.ui.WeatherScreen
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.utils.animated
import com.google.accompanist.insets.ProvideWindowInsets

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<WeatherViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            MyTheme(viewModel.weatherState.collectAsState().value.weatherType) {
                ProvideWindowInsets {
                    MyApp(viewModel)
                }
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp(viewModel: WeatherViewModel) {
    Surface(color = MaterialTheme.colors.background.animated()) {
        WeatherScreen(viewModel = viewModel)
    }
}
