package com.ali.covid_case.network

import com.ali.covid_case.network.response.CountryResponse
import com.ali.covid_case.network.response.History.HistoryResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("countries")
    fun getCountries(): Call<CountryResponse>?
    @GET("history")
    fun getHistory(@Query("day") day: String?, @Query("country") country: String?): Call<HistoryResponse>?
}