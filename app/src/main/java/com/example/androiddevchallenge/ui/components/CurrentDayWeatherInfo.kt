package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.layout.*
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
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Icon(
            modifier = Modifier.size(200.dp),
            painter = painterResource(
                when (currentDayWeatherType) {
                    WeatherType.SUNNY -> R.drawable.ic_sunny
                    WeatherType.RAINY -> R.drawable.ic_rainy
                    WeatherType.CLOUDY -> R.drawable.ic_cloudy
                    WeatherType.STORMY -> R.drawable.ic_stormy
                }
            ),
            contentDescription = "Current Day Weather Type"
        )
        Text(
            text = currentDayWeatherType.toString(),
            style = MaterialTheme.typography.caption.copy(fontWeight = FontWeight.Bold)
        )
        Spacer(Modifier.size(10.dp))
        Text(text = "84${StringConstants.DEGREE}", style = MaterialTheme.typography.h1)
    }
}
