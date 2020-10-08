package com.ali.mapapps.network

import com.ali.mapapps.Util.Cv
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


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
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(Cv.BASR_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        myApi = retrofit.create(Api::class.java)
    }
}