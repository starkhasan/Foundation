package com.ali.sampleandroid.network
import com.ali.sampleandroid.network.response.UserResponse
import com.ali.sampleandroid.utils.Helper
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("/posts")
    fun getUser(): Call<List<UserResponse>>


    companion object {
        fun retroClient() : ApiService {
            val client = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Helper.BASE_URL)
                .build()
            return client.create(ApiService::class.java)
        }
    }
}