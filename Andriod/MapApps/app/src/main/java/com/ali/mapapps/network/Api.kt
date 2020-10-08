package com.ali.mapapps.network

import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET("weather")
    fun getWeather() : Call<>?
}