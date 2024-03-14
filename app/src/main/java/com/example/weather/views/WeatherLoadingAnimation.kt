package com.example.weather.views

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.weather.R

@Composable
fun WeatherLoadingAnimation() {
    val infiniteTransition = rememberInfiniteTransition(label = "")
    // create an animation for state for the scale factor
    val scale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 1.2f,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 1000
                1.2f at 500
                1f at 1000
            },
            repeatMode = RepeatMode.Reverse,
        ),
        label = "scale"
    )

    // Apply the zoom effect to the image
    Image(
        painter = painterResource(id = R.drawable.weather),
        contentDescription = null,
        modifier = Modifier
            .size(100.dp)
            .scale(scale)
    )

}