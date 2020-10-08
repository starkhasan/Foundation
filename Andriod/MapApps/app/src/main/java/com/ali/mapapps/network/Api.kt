package com.ali.mapapps.network

import com.ali.mapapps.network.response.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("weather")
    fun getWeather(@Query("q") city_name:String,@Query("appid") appid:String) : Call<WeatherResponse>
}