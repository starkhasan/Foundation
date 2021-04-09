package com.ali.demoproject.ui.activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ali.demoproject.R
import com.ali.demoproject.model.DriverLocation
import com.ali.demoproject.network.Api
import kotlinx.android.synthetic.main.custom_toolbar.*
import okhttp3.OkHttp
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiCheckingActivity : AppCompatActivity() , View.OnClickListener{

    var api: Api?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_api_checking)
        setToolbar()

        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor { chain ->
            chain.proceed(chain.request().newBuilder()
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("Accept", "application/json")
                .addHeader("Authorization","Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ0b2tlbl90eXBlIjoiYWNjZXNzIiwiZXhwIjoxNjEyMDEzMzI1LCJqdGkiOiJhODk2MTczY2ViZjg0YzZlOTA2MDA1OWI5Mzc3NzA4MCIsInVzZXJfaWQiOjEsInVzZXJuYW1lIjoiMzg1ODIxIiwiZ3JvdXBzIjpbXX0.6UYfi-DTF_uJqsx5V9vJR-WwoVTm7Yz4Ysxw-Ui9I3E")
                .build())
        }
        val map = HashMap<String, Any>()
        map["lat"] = 25.675678
        map["lang"] = 84.846281663

        val retrofit = Retrofit.Builder()
            .baseUrl("http://3.131.97.186:8000/")
            .client(httpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        api = retrofit.create(Api::class.java)
        api!!.updateDriverLocation(1, map)!!.enqueue(object : Callback<DriverLocation> {
            override fun onResponse(
                call: Call<DriverLocation>,
                response: Response<DriverLocation>
            ) {
                if (response.isSuccessful) {
                    Toast.makeText(applicationContext, "Working Sucessfully", Toast.LENGTH_SHORT)
                        .show()
                }
            }

            override fun onFailure(call: Call<DriverLocation>, t: Throwable) {
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show()
            }
        })
    }

    fun setToolbar(){
        ivNav.setImageDrawable(getDrawable(R.drawable.icon_back))
        tvHeading.text = "Api Checking"
        ivNav.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.ivNav -> {
                finish()
            }
        }
    }
}