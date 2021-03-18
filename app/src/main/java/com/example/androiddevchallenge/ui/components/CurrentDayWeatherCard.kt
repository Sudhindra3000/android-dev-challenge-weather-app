package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.constants.StringConstants

@Composable
fun CurrentDayWeatherCard(modifier: Modifier) {
    Surface(
        modifier,
        shape = MaterialTheme.shapes.medium,
        elevation = 5.dp
    ) {
        Row(
            Modifier.padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(text = "Heavy Rain")
                Text(text = "Morning")
            }
            Text(text = "84${StringConstants.DEGREE}", style = MaterialTheme.typography.h4)
        }
    }
}
