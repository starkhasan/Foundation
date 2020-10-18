package com.example.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.widget.Toast
import org.greenrobot.eventbus.EventBus


class MyBroadcastReceiver : BroadcastReceiver(){
    override fun onReceive(context: Context?, intent: Intent?) {
        isNetworkAvailable(context)
    }

    fun isNetworkAvailable(context: Context?){
        val connectivityManager = context!!.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if(connectivityManager.activeNetworkInfo!=null){
            val activeNetwork = connectivityManager.activeNetworkInfo as NetworkInfo
            if(activeNetwork!=null && activeNetwork.isConnectedOrConnecting) {
                EventBus.getDefault().post(MessageEvent("true"))
            }else {
                EventBus.getDefault().post(MessageEvent("false"))
            }
        }else{
            EventBus.getDefault().post(MessageEvent("false"))
        }

    }
}