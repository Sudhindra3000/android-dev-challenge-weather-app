package com.example.androiddevchallenge.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.WeatherViewModel
import com.example.androiddevchallenge.ui.components.CurrentDayWeatherInfo
import com.example.androiddevchallenge.ui.components.DailyForecastCard
import com.example.androiddevchallenge.ui.components.HourlyForecastCard
import com.example.androiddevchallenge.ui.components.WeatherDetailsCard
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.rememberInsetsPaddingValues
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun WeatherScreen(viewModel: WeatherViewModel) {
    val refreshing = viewModel.refreshing.collectAsState().value
    val refreshState = rememberSwipeRefreshState(isRefreshing = refreshing)

    SwipeRefresh(
        state = refreshState,
        onRefresh = viewModel::refresh
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(
                    rememberInsetsPaddingValues(
                        insets = LocalWindowInsets.current.systemBars
                    )
                )
                .padding(15.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CurrentDayWeatherInfo(
                Modifier.fillMaxWidth(),
                viewModel.currentDayWeatherType.collectAsState().value
            )
            WeatherDetailsCard(Modifier.fillMaxWidth())
            HourlyForecastCard(Modifier.fillMaxWidth())
            DailyForecastCard(Modifier.fillMaxWidth())
        }
    }
}
