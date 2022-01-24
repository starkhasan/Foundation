package com.ceryl.ceryl.app

import android.app.Application
import android.content.Context
import com.ceryl.ceryl.network.Api
import com.ceryl.ceryl.util.Cv
import com.ceryl.ceryl.util.Preferences
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
        fun getApi(ctx:Context): Api?{
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
                .addHeader("Content-Type", "application/json")
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