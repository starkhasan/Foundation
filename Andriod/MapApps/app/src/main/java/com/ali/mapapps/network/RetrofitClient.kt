package com.ali.mapapps.network

import com.ali.mapapps.Util.Cv
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException


class RetrofitClient private constructor() {
    val myApi: Api

    companion object {
        private var instance: RetrofitClient? = null
        fun getInstance():RetrofitClient{
            if(instance == null)
                instance = RetrofitClient()
            return instance as RetrofitClient
        }
    }

    init {
        val httpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))

        val retrofit = Retrofit.Builder()
            .baseUrl(Cv.BASR_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()
        myApi = retrofit.create(Api::class.java)
    }
}