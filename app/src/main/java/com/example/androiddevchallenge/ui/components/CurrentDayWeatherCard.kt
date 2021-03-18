package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.example.androiddevchallenge.constants.StringConstants
import com.example.androiddevchallenge.models.WeatherType

@Composable
fun CurrentDayWeatherCard(
    modifier: Modifier,
    currentDayWeatherType: WeatherType
) {
    Surface(
        modifier,
        shape = MaterialTheme.shapes.medium,
        elevation = 5.dp
    ) {
        Column(
            Modifier.padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Icon(
                modifier = Modifier.size(200.dp),
                painter = painterResource(id = if (currentDayWeatherType == WeatherType.SUNNY) R.drawable.ic_sunny else R.drawable.ic_cloudy),
                contentDescription = "Current Day Weather Type"
            )
            Text(text = currentDayWeatherType.toString(), style = MaterialTheme.typography.caption)
            Text(text = "84${StringConstants.DEGREE}", style = MaterialTheme.typography.h4)
            Text(text = "Heavy Rain")
            Text(text = "Morning")
        }
    }
}
