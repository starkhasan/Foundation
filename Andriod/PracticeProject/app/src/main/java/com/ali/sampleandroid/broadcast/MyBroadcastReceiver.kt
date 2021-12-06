package com.ali.sampleandroid.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val action = intent?.action
        if(Intent.ACTION_POWER_CONNECTED.equals(action)){
            Toast.makeText(context,"Connected",Toast.LENGTH_SHORT).show()
        }else if(Intent.ACTION_AIRPLANE_MODE_CHANGED.equals(action)){
            Toast.makeText(context,"Airplace mode changed",Toast.LENGTH_SHORT).show()
        }else if(Intent.ACTION_POWER_DISCONNECTED.equals(action)){
            Toast.makeText(context,"Power Disconnect",Toast.LENGTH_SHORT).show()
        }else if(action ==  "LOCAL_BROADCAST"){
            val message = intent.extras
            Toast.makeText(context,"LOCAL_BROADCAST -> ${message?.get("message")}",Toast.LENGTH_SHORT).show()
        }
    }
}