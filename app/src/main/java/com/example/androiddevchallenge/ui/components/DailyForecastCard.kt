package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.constants.StringConstants
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
        weatherType = WeatherType.STORMY,
        weekDay = "Wed",
        date = "Mar 24",
        maxTemp = 91,
        minTemp = 62
    ),
)

@Composable
fun DailyForecastCard(modifier: Modifier) {
    Surface(
        modifier,
        shape = MaterialTheme.shapes.medium
    ) {
        Column(
            Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Text(text = "Daily Forecast", fontWeight = FontWeight.Bold)
            sampleDailyForecastData.forEach {
                DailyForecastItem(Modifier.fillMaxWidth(), data = it)
            }
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
        Text(modifier = Modifier.weight(1f), text = buildAnnotatedString {
            withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
                append("$maxT${StringConstants.DEGREE} ")
            }
            withStyle(SpanStyle()) {
                append("$minT${StringConstants.DEGREE}")
            }
        }, textAlign = TextAlign.Justify)
        Icon(
            modifier = Modifier.weight(1f, false),
            painter = painterResource(
                when (type) {
                    WeatherType.SUNNY -> R.drawable.ic_sunny
                    WeatherType.RAINY -> R.drawable.ic_rainy
                    WeatherType.CLOUDY -> R.drawable.ic_cloudy
                    WeatherType.STORMY -> R.drawable.ic_stormy
                }
            ),
            contentDescription = "Daily Forecast Weather Type"
        )
    }
}
