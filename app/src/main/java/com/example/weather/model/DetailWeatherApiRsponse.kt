package com.example.weather.model


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class DetailWeatherApiRsponse(
    @Expose
    val alerts: Alerts? = null,
    @Expose
    val current: Current? = null,
    @Expose
    val forecast: Forecast? = null,
    @Expose
    val location: Location? = null
) {
    data class Alerts(
        @Expose
        val alert: List<Any?>? = null
    )

    data class Current(
        @SerializedName("air_quality")
        @Expose
        val airQuality: AirQuality? = null,
        @Expose
        val cloud: Int? = null, // 25
        @Expose
        val condition: Condition? = null,
        @SerializedName("feelslike_c")
        @Expose
        val feelslikeC: Double? = null, // 10.1
        @SerializedName("feelslike_f")
        @Expose
        val feelslikeF: Double? = null, // 50.1
        @SerializedName("gust_kph")
        @Expose
        val gustKph: Double? = null, // 22.8
        @SerializedName("gust_mph")
        @Expose
        val gustMph: Double? = null, // 14.2
        @Expose
        val humidity: Int? = null, // 82
        @SerializedName("is_day")
        @Expose
        val isDay: Int? = null, // 1
        @SerializedName("last_updated")
        @Expose
        val lastUpdated: String? = null, // 2024-03-14 10:15
        @SerializedName("last_updated_epoch")
        @Expose
        val lastUpdatedEpoch: Int? = null, // 1710411300
        @SerializedName("precip_in")
        @Expose
        val precipIn: Double? = null, // 0.0
        @SerializedName("precip_mm")
        @Expose
        val precipMm: Double? = null, // 0.0
        @SerializedName("pressure_in")
        @Expose
        val pressureIn: Double? = null, // 29.77
        @SerializedName("pressure_mb")
        @Expose
        val pressureMb: Double? = null, // 1008.0
        @SerializedName("temp_c")
        @Expose
        val tempC: Double? = null, // 12.0
        @SerializedName("temp_f")
        @Expose
        val tempF: Double? = null, // 53.6
        @Expose
        val uv: Double? = null, // 3.0
        @SerializedName("vis_km")
        @Expose
        val visKm: Double? = null, // 10.0
        @SerializedName("vis_miles")
        @Expose
        val visMiles: Double? = null, // 6.0
        @SerializedName("wind_degree")
        @Expose
        val windDegree: Int? = null, // 200
        @SerializedName("wind_dir")
        @Expose
        val windDir: String? = null, // SSW
        @SerializedName("wind_kph")
        @Expose
        val windKph: Double? = null, // 15.1
        @SerializedName("wind_mph")
        @Expose
        val windMph: Double? = null // 9.4
    ) {
        data class AirQuality(
            @Expose
            val co: Double? = null, // 273.7
            @SerializedName("gb-defra-index")
            @Expose
            val gbDefraIndex: Int? = null, // 1
            @Expose
            val no2: Double? = null, // 23.0
            @Expose
            val o3: Double? = null, // 34.3
            @Expose
            val pm10: Double? = null, // 8.1
            @SerializedName("pm2_5")
            @Expose
            val pm25: Double? = null, // 6.1
            @Expose
            val so2: Double? = null, // 13.4
            @SerializedName("us-epa-index")
            @Expose
            val usEpaIndex: Int? = null // 1
        )

        data class Condition(
            @Expose
            val code: Int? = null, // 1003
            @Expose
            val icon: String? = null, // //cdn.weatherapi.com/weather/64x64/day/116.png
            @Expose
            val text: String? = null // Partly cloudy
        )
    }

    data class Forecast(
        @Expose
        val forecastday: List<Forecastday?>? = null
    ) {
        data class Forecastday(
            @Expose
            val astro: Astro? = null,
            @Expose
            val date: String? = null, // 2024-03-14
            @SerializedName("date_epoch")
            @Expose
            val dateEpoch: Int? = null, // 1710374400
            @Expose
            val day: Day? = null,
            @Expose
            val hour: List<Hour?>? = null
        ) {
            data class Astro(
                @SerializedName("is_moon_up")
                @Expose
                val isMoonUp: Int? = null, // 0
                @SerializedName("is_sun_up")
                @Expose
                val isSunUp: Int? = null, // 0
                @SerializedName("moon_illumination")
                @Expose
                val moonIllumination: Int? = null, // 18
                @SerializedName("moon_phase")
                @Expose
                val moonPhase: String? = null, // Waxing Crescent
                @Expose
                val moonrise: String? = null, // 07:44 AM
                @Expose
                val moonset: String? = null, // No moonset
                @Expose
                val sunrise: String? = null, // 06:16 AM
                @Expose
                val sunset: String? = null // 06:04 PM
            )

            data class Day(
                @SerializedName("air_quality")
                @Expose
                val airQuality: AirQuality? = null,
                @Expose
                val avghumidity: Int? = null, // 80
                @SerializedName("avgtemp_c")
                @Expose
                val avgtempC: Double? = null, // 11.8
                @SerializedName("avgtemp_f")
                @Expose
                val avgtempF: Double? = null, // 53.3
                @SerializedName("avgvis_km")
                @Expose
                val avgvisKm: Double? = null, // 10.0
                @SerializedName("avgvis_miles")
                @Expose
                val avgvisMiles: Double? = null, // 6.0
                @Expose
                val condition: Condition? = null,
                @SerializedName("daily_chance_of_rain")
                @Expose
                val dailyChanceOfRain: Int? = null, // 88
                @SerializedName("daily_chance_of_snow")
                @Expose
                val dailyChanceOfSnow: Int? = null, // 0
                @SerializedName("daily_will_it_rain")
                @Expose
                val dailyWillItRain: Int? = null, // 1
                @SerializedName("daily_will_it_snow")
                @Expose
                val dailyWillItSnow: Int? = null, // 0
                @SerializedName("maxtemp_c")
                @Expose
                val maxtempC: Double? = null, // 15.4
                @SerializedName("maxtemp_f")
                @Expose
                val maxtempF: Double? = null, // 59.7
                @SerializedName("maxwind_kph")
                @Expose
                val maxwindKph: Double? = null, // 23.4
                @SerializedName("maxwind_mph")
                @Expose
                val maxwindMph: Double? = null, // 14.5
                @SerializedName("mintemp_c")
                @Expose
                val mintempC: Double? = null, // 9.2
                @SerializedName("mintemp_f")
                @Expose
                val mintempF: Double? = null, // 48.6
                @SerializedName("totalprecip_in")
                @Expose
                val totalprecipIn: Double? = null, // 0.02
                @SerializedName("totalprecip_mm")
                @Expose
                val totalprecipMm: Double? = null, // 0.51
                @SerializedName("totalsnow_cm")
                @Expose
                val totalsnowCm: Double? = null, // 0.0
                @Expose
                val uv: Double? = null // 3.0
            ) {
                data class AirQuality(
                    @SerializedName("aqi_data")
                    @Expose
                    val aqiData: String? = null, // null
                    @Expose
                    val co: Double? = null, // 254.47599999999994
                    @SerializedName("gb-defra-index")
                    @Expose
                    val gbDefraIndex: Int? = null, // 1
                    @Expose
                    val no2: Double? = null, // 21.471999999999998
                    @Expose
                    val o3: Double? = null, // 44.61600000000001
                    @Expose
                    val pm10: Double? = null, // 8.452
                    @SerializedName("pm2_5")
                    @Expose
                    val pm25: Double? = null, // 6.8000000000000025
                    @Expose
                    val so2: Double? = null, // 9.38
                    @SerializedName("us-epa-index")
                    @Expose
                    val usEpaIndex: Int? = null // 1
                )

                data class Condition(
                    @Expose
                    val code: Int? = null, // 1063
                    @Expose
                    val icon: String? = null, // //cdn.weatherapi.com/weather/64x64/day/176.png
                    @Expose
                    val text: String? = null // Patchy rain nearby
                )
            }

            data class Hour(
                @SerializedName("air_quality")
                @Expose
                val airQuality: AirQuality? = null,
                @SerializedName("chance_of_rain")
                @Expose
                val chanceOfRain: Int? = null, // 0
                @SerializedName("chance_of_snow")
                @Expose
                val chanceOfSnow: Int? = null, // 0
                @Expose
                val cloud: Int? = null, // 92
                @Expose
                val condition: Condition? = null,
                @SerializedName("dewpoint_c")
                @Expose
                val dewpointC: Double? = null, // 8.1
                @SerializedName("dewpoint_f")
                @Expose
                val dewpointF: Double? = null, // 46.7
                @SerializedName("diff_rad")
                @Expose
                val diffRad: Double? = null, // 0.0
                @SerializedName("feelslike_c")
                @Expose
                val feelslikeC: Double? = null, // 8.8
                @SerializedName("feelslike_f")
                @Expose
                val feelslikeF: Double? = null, // 47.9
                @SerializedName("gust_kph")
                @Expose
                val gustKph: Double? = null, // 25.8
                @SerializedName("gust_mph")
                @Expose
                val gustMph: Double? = null, // 16.0
                @SerializedName("heatindex_c")
                @Expose
                val heatindexC: Double? = null, // 10.8
                @SerializedName("heatindex_f")
                @Expose
                val heatindexF: Double? = null, // 51.5
                @Expose
                val humidity: Int? = null, // 83
                @SerializedName("is_day")
                @Expose
                val isDay: Int? = null, // 0
                @SerializedName("precip_in")
                @Expose
                val precipIn: Double? = null, // 0.0
                @SerializedName("precip_mm")
                @Expose
                val precipMm: Double? = null, // 0.0
                @SerializedName("pressure_in")
                @Expose
                val pressureIn: Double? = null, // 29.86
                @SerializedName("pressure_mb")
                @Expose
                val pressureMb: Double? = null, // 1011.0
                @SerializedName("short_rad")
                @Expose
                val shortRad: Double? = null, // 0.0
                @SerializedName("snow_cm")
                @Expose
                val snowCm: Double? = null, // 0.0
                @SerializedName("temp_c")
                @Expose
                val tempC: Double? = null, // 10.8
                @SerializedName("temp_f")
                @Expose
                val tempF: Double? = null, // 51.5
                @Expose
                val time: String? = null, // 2024-03-14 00:00
                @SerializedName("time_epoch")
                @Expose
                val timeEpoch: Int? = null, // 1710374400
                @Expose
                val uv: Double? = null, // 1.0
                @SerializedName("vis_km")
                @Expose
                val visKm: Double? = null, // 10.0
                @SerializedName("vis_miles")
                @Expose
                val visMiles: Double? = null, // 6.0
                @SerializedName("will_it_rain")
                @Expose
                val willItRain: Int? = null, // 0
                @SerializedName("will_it_snow")
                @Expose
                val willItSnow: Int? = null, // 0
                @SerializedName("wind_degree")
                @Expose
                val windDegree: Int? = null, // 207
                @SerializedName("wind_dir")
                @Expose
                val windDir: String? = null, // SSW
                @SerializedName("wind_kph")
                @Expose
                val windKph: Double? = null, // 16.2
                @SerializedName("wind_mph")
                @Expose
                val windMph: Double? = null, // 10.1
                @SerializedName("windchill_c")
                @Expose
                val windchillC: Double? = null, // 8.8
                @SerializedName("windchill_f")
                @Expose
                val windchillF: Double? = null // 47.9
            ) {
                data class AirQuality(
                    @Expose
                    val co: Double? = null, // 250.3
                    @SerializedName("gb-defra-index")
                    @Expose
                    val gbDefraIndex: Int? = null, // 1
                    @Expose
                    val no2: Double? = null, // 21.6
                    @Expose
                    val o3: Double? = null, // 47.2
                    @Expose
                    val pm10: Double? = null, // 12.1
                    @SerializedName("pm2_5")
                    @Expose
                    val pm25: Double? = null, // 8.1
                    @Expose
                    val so2: Double? = null, // 8.4
                    @SerializedName("us-epa-index")
                    @Expose
                    val usEpaIndex: Int? = null // 1
                )

                data class Condition(
                    @Expose
                    val code: Int? = null, // 1009
                    @Expose
                    val icon: String? = null, // //cdn.weatherapi.com/weather/64x64/night/122.png
                    @Expose
                    val text: String? = null // Overcast 
                )
            }
        }
    }

    data class Location(
        @Expose
        val country: String? = null, // United Kingdom
        @Expose
        val lat: Double? = null, // 51.52
        @Expose
        val localtime: String? = null, // 2024-03-14 10:28
        @SerializedName("localtime_epoch")
        @Expose
        val localtimeEpoch: Int? = null, // 1710412105
        @Expose
        val lon: Double? = null, // -0.11
        @Expose
        val name: String? = null, // London
        @Expose
        val region: String? = null, // City of London, Greater London
        @SerializedName("tz_id")
        @Expose
        val tzId: String? = null // Europe/London
    )
}



 fun DetailWeatherApiRsponse.toWeatherUiModel(): WeatherUiModel {
    val location = "${location?.name}, ${location?.region}, ${location?.country}"
    val temperature = "${current?.tempC}°C / ${current?.tempF}°F"
    val condition = current?.condition?.text?:""
    val wind = "${current?.windKph} km/h ${current?.windDir}"
    val pressure = "${current?.pressureMb} mb"
    val humidity = "${current?.humidity}%"
    val feelsLike = "${current?.feelslikeC}°C / ${current?.feelslikeF}°F"
    val visibility = "${current?.visKm} km / ${current?.visMiles} miles"
    val uvIndex = current?.uv
    val cloudiness = "${current?.cloud}%"
    val precipitation = "${current?.precipMm} mm / ${current?.precipIn} in"
    val gust = "${current?.gustMph} mph / ${current?.gustKph} km/h"

     val forecasts = forecast?.forecastday?.map { forecastDay ->
         ForecastForeWeekItem(
             date = forecastDay?.date ?: "",
             dayTemp = "${forecastDay?.day?.avgtempC}°C / ${forecastDay?.day?.avgtempF}°F",
             nightTemp = "${forecastDay?.astro?.moonrise} / ${forecastDay?.astro?.moonset}",
             weeklyWeatherIcon = forecastDay?.hour?.map { hour ->
                 WeeklyWeatherIcon(description = hour?.condition?.text ?: "")
             } ?: emptyList()
         )
     }

    return WeatherUiModel(
        location = location,
        temperature = temperature,
        weatherCondition = condition,
        windSpeed =  wind,
        pressure = pressure,
        humidity = humidity,
        feelsLike = feelsLike,
        visibility = visibility,
        uvIndex = uvIndex,
        cloudiness = cloudiness,
        precipitation = precipitation,
        gust = gust,
        todayWeatherIcon = listOf(
            TodayWeatherIcon(time = current?.lastUpdated ?: "",
            weatherIcon = current?.condition?.text ?: "")
        ),
        forecastForeWeek = forecasts?: emptyList()
    )
}