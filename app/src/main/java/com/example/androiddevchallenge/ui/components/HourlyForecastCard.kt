package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
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
        WeatherType.CLOUDY,
        2,
        false,
        93
    ),
    HourlyForecastData(
        WeatherType.CLOUDY,
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
        WeatherType.CLOUDY,
        7,
        false,
        84
    ),
    HourlyForecastData(
        WeatherType.CLOUDY,
        8,
        false,
        82
    ),
    HourlyForecastData(
        WeatherType.CLOUDY,
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
            Text(text = "Hourly Forecast")
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
            painter = painterResource(if (type == WeatherType.SUNNY) R.drawable.ic_sunny else R.drawable.ic_cloudy),
            contentDescription = "Weather Type"
        )
        Text(text = "$temperature$DEGREE")
    }
}
