package com.ali.demoproject.network

import com.ali.demoproject.model.DriverLocation
import com.ali.demoproject.model.UserModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface Api {
    @GET("photos")
    fun getUser() : Call<List<UserModel>>?
    @PUT("vehicle/update-drivers-location/{id}/")
    fun updateDriverLocation(@Path("id") id:Int,@Body map:HashMap<String,Any>) : Call<DriverLocation>?
}