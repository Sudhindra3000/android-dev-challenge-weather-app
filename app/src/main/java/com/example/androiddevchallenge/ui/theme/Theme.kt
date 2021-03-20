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
package com.example.androiddevchallenge.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import com.example.androiddevchallenge.models.WeatherType

private val SunnyColorPalette = lightColors(
    primary = red500,
    primaryVariant = red500,
    secondary = blue900,

    background = red500,
    surface = red200,

    onPrimary = bluishGrey,
    onSurface = bluishGrey
)

private val CloudyColorPalette = lightColors(
    primary = blue500,
    primaryVariant = blue500,
    secondary = blue900,

    background = blue500,
    surface = blue200,

    onPrimary = bluishGrey,
    onSurface = bluishGrey
)

private val StormyColorPalette = lightColors(
    primary = yellow500,
    primaryVariant = yellow500,
    secondary = blue900,

    background = yellow500,
    surface = yellow200,

    onPrimary = bluishGrey,
    onSurface = bluishGrey
)

@Composable
fun MyTheme(
    weatherType: WeatherType,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = when (weatherType) {
        WeatherType.SUNNY -> SunnyColorPalette
        WeatherType.CLOUDY -> CloudyColorPalette
        WeatherType.STORMY -> StormyColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}
