package com.example.androiddevchallenge.utils

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.spring
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun Color.animated(
    animationSpec: AnimationSpec<Color> = spring(),
    finishedListener: ((Color) -> Unit)? = null,
) = animateColorAsState(
    targetValue = this,
    animationSpec = animationSpec,
    finishedListener = finishedListener,
).value
