package com.example.weather.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
import com.example.weather.model.WeatherUiModel
import com.example.weather.utils.todayDate
import com.example.weather.ui.theme.textColor

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun WeatherLoadedScreen(data: WeatherUiModel) {
    Spacer(modifier = Modifier.size(10.dp))
    Text(
        text = data.location,
        modifier = Modifier.padding(start = 20.dp),
        style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp, color = textColor)
    )
    Text(
        text = todayDate(),
        modifier = Modifier.padding(start = 20.dp),
        style = TextStyle(fontSize = 16.sp, color = textColor)
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.Center,
    ) {
        Card(
            modifier = Modifier
                .size(80.dp)
                .align(Alignment.CenterVertically),
            shape = RoundedCornerShape(40.dp),
            elevation = CardDefaults.cardElevation(),
        ) {
            GlideImage(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                model = getWeatherIcon(data.todayWeatherIcon[0].weatherIcon.lowercase()),
                contentScale = ContentScale.Crop,
                contentDescription = stringResource(R.string.image),
            )
        }

    }
    Text(
        text = data.temperature,
        modifier = Modifier.padding(start = 10.dp),
        style = TextStyle(
            fontWeight = FontWeight.Bold, fontSize = 24.sp, color = textColor
        )
    )

    Spacer(modifier = Modifier.size(15.dp))
    Column(modifier = Modifier.padding(start = 20.dp, end = 20.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            DailyItem(
                R.drawable.temprature, data.feelsLike, "Feels Like"
            )
            DailyItem(
                R.drawable.visibility, data.visibility, "Visibility"
            )
            DailyItem(
                R.drawable.uv_rays, data.uvIndex.toString(), "UV Rays"
            )
        }
        Spacer(modifier = Modifier.size(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            DailyItem(
                R.drawable.humidity, data.humidity, "Humidity"
            )
            DailyItem(
                R.drawable.wind_speed, data.windSpeed, "Wind Speed"
            )
            DailyItem(
                R.drawable.pressure, data.pressure, "Air Pressure"
            )
        }
    }
    Spacer(modifier = Modifier.size(25.dp))
    Text(
        text = stringResource(id = R.string.weekly_forecast),
        modifier = Modifier.padding(start = 20.dp),
        style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp, color = textColor)
    )

    WeeklyForecastView(data.forecastForeWeek)

}