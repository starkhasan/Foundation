package com.ali.mapapps.Util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.util.Log
import java.util.*

class Helper {
    companion object{
        fun isConnected(context: Context): Boolean {
            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo = connectivityManager.activeNetworkInfo
            if(networkInfo != null)
                return  networkInfo!=null && networkInfo.isConnectedOrConnecting
            return false
        }

        fun getDate():String{
            var date = Date()
            val calendar = Calendar.getInstance()
            val today_date = calendar.time.toString()
            val day_month = today_date.subSequence(0,11)
            val year = today_date.subSequence(30,34)
            val temp =  StringBuilder()
            temp.append(day_month).append(" ").append(year)
            return temp.toString()
        }
        fun kelvintoCelcius(kelvin:Double):String{
            val celcius = kelvin - 273.15
            return celcius.toString()
        }
    }
}