package com.example.androiddevchallenge

import com.example.androiddevchallenge.models.WeatherType

data class WeatherState(
    val isRefreshing: Boolean,
    val weatherType: WeatherType,
)
