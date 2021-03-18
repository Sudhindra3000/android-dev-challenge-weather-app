package com.example.androiddevchallenge

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.models.WeatherType

class MainViewModel : ViewModel() {

    private val _currentDayWeatherType = MutableLiveData<WeatherType>()
    val currentDayWeatherType: LiveData<WeatherType> = _currentDayWeatherType
}
