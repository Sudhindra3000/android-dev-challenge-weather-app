package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.models.WeatherType

data class DailyForecastData(
    val weatherType: WeatherType,
    val weekDay: String,
    val date: String,
    val maxTemp: Int,
    val minTemp: Int
)

val sampleDailyForecastData = listOf(
    DailyForecastData(
        weatherType = WeatherType.SUNNY,
        weekDay = "Today",
        date = "Mar 18",
        maxTemp = 93,
        minTemp = 68
    ),
    DailyForecastData(
        weatherType = WeatherType.CLOUDY,
        weekDay = "Fri",
        date = "Mar 19",
        maxTemp = 93,
        minTemp = 68
    ),
    DailyForecastData(
        weatherType = WeatherType.SUNNY,
        weekDay = "Sat",
        date = "Mar 20",
        maxTemp = 91,
        minTemp = 69
    ),
    DailyForecastData(
        weatherType = WeatherType.SUNNY,
        weekDay = "Sun",
        date = "Mar 21",
        maxTemp = 93,
        minTemp = 68
    ),
    DailyForecastData(
        weatherType = WeatherType.SUNNY,
        weekDay = "Mon",
        date = "Mar 22",
        maxTemp = 93,
        minTemp = 68
    ),
    DailyForecastData(
        weatherType = WeatherType.CLOUDY,
        weekDay = "Tue",
        date = "Mar 23",
        maxTemp = 95,
        minTemp = 66
    ),
    DailyForecastData(
        weatherType = WeatherType.CLOUDY,
        weekDay = "Wed",
        date = "Mar 24",
        maxTemp = 91,
        minTemp = 62
    ),
)

@Composable
fun DailyForecastCard(modifier: Modifier) {
    Column(
        modifier,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(text = "Daily Forecast")
        sampleDailyForecastData.forEach {
            DailyForecastItem(Modifier.fillMaxWidth(), data = it)
        }
    }
}

@Composable
fun DailyForecastItem(
    modifier: Modifier,
    data: DailyForecastData
) {
    val (type, weekDay, date, maxT, minT) = data
    Row(
        modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(modifier = Modifier.weight(1f), text = "$weekDay, $date")
        Text(modifier = Modifier.weight(1f), text = "$maxT  $minT", textAlign = TextAlign.Center)
        Icon(
            modifier = Modifier.weight(1f, false),
            painter = painterResource(if (type == WeatherType.SUNNY) R.drawable.ic_sunny else R.drawable.ic_cloudy),
            contentDescription = "Daily Forecast Weather Type"
        )
    }
}
