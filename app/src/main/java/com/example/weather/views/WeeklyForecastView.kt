package com.example.weather.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.weather.R
import com.example.weather.utils.getWeatherIcon
import com.example.weather.model.ForecastForeWeekItem
import com.example.weather.ui.theme.textColor

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun WeeklyForecastView(forecastForeWeek: List<ForecastForeWeekItem>) {
    LazyColumn {
        items(forecastForeWeek.size) { index ->
            val item = forecastForeWeek[index]
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                shape = RoundedCornerShape(CornerSize(15.dp)),
                // backgroundColor = weeklyItemBackgroundColor,
                elevation = CardDefaults.cardElevation()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    Text(
                        text = item.date,
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            color = textColor
                        )
                    )
                    Spacer(modifier = Modifier.size(10.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = item.dayTemp,
                            style = TextStyle(fontSize = 16.sp, color = textColor)
                        )
                        Text(
                            text = item.nightTemp,
                            style = TextStyle(fontSize = 16.sp, color = textColor)
                        )
                    }
                    Spacer(modifier = Modifier.size(10.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = item.weeklyWeatherIcon[0].description,
                            style = TextStyle(fontSize = 16.sp, color = textColor)
                        )
                        GlideImage(
                            modifier = Modifier.size(30.dp),
                            model = getWeatherIcon(item.weeklyWeatherIcon[0].description.lowercase()),
                            contentScale = ContentScale.Crop,
                            contentDescription = stringResource(R.string.image),
                        )
                    }
                }
            }
        }

    }
}