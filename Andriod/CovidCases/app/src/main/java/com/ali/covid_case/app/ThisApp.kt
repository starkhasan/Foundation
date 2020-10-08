package com.ali.covid_case.app

import android.app.Application
import android.content.Context
import com.ali.covid_case.network.Api
import com.ali.covid_case.util.Cv
import com.ali.covid_case.util.Preferences
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ThisApp : Application() {

    operator fun get(ctx: Context): ThisApp? {
        return ctx.applicationContext as ThisApp
    }

    companion object{
        lateinit var mInstance: ThisApp
        fun getApi(ctx: Context): Api?{
            return ThisApp()[ctx]!!.api
        }
    }

    var api: Api? = null

    override fun onCreate() {
        super.onCreate()
        Preferences.init(this)
        mInstance = this
        api=createApi()

        /*val appSignature = AppSignatureHelper(this)
        Log.v("AppSignature", appSignature.appSignatures.toString())
        Preferences.hash=""
        Preferences.hash = appSignature.appSignatures.toString()*/
    }

    @Synchronized
    fun getInstance(): ThisApp? {
        return mInstance
    }



    private fun createApi():Api?{
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = (HttpLoggingInterceptor.Level.BODY)
        val client= OkHttpClient.Builder()
        client.readTimeout(60, TimeUnit.SECONDS)
        client.connectTimeout(60, TimeUnit.SECONDS)

        client.addInterceptor { chain ->
            chain.proceed(chain.request().newBuilder()
                .addHeader("Content-Type", "application/json; charset=UTF-8")
                .addHeader("x-rapidapi-host", "covid-193.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "3d54eaa871msh2d93a484635551cp1a4debjsn898d6d43af4c")
                .build())

        }
        client.addInterceptor(interceptor)
        return Retrofit.Builder()
            .baseUrl(Cv.BaseUrl)
            .client(client.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api::class.java)
    }
}