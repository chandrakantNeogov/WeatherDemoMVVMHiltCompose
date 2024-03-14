package com.example.weather.di

import com.example.weather.networking.NetworkingService
import com.example.weather.repository.WeatherRepository
import com.example.weather.repository.WeatherRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    // provide NetworkingService to  WeatherRepositoryImpl

    @Provides
    fun provideNetworkingService(networkingService: NetworkingService): WeatherRepository {
       return WeatherRepositoryImpl(networkingService)
    }


    @Provides
    fun provideRetrofit(): NetworkingService {
        return Retrofit.Builder()
            .client(getOkHhtpClient())
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NetworkingService::class.java)

    }

    private fun getOkHhtpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(NETWORK_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(NETWORK_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(NETWORK_TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                })
            .build()

    }

    companion object {
        const val NETWORK_TIMEOUT = 60L
        const val BASE_URL = "https://api.weatherapi.com/v1/"
        const val API_KEY = "b1255cdec1f1400297b60533241403"
    }
}