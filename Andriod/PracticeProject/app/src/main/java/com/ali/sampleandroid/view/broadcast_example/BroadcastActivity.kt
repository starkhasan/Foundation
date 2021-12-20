package com.ali.sampleandroid.view.broadcast_example

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.ali.sampleandroid.broadcast.MyBroadcastReceiver
import com.ali.sampleandroid.databinding.ActivityBroadcastBinding

class BroadcastActivity : AppCompatActivity() {

    lateinit var broadcastReceiver: MyBroadcastReceiver
    lateinit var localBroadcastManager: LocalBroadcastManager

    lateinit var activityBroadcastBinding: ActivityBroadcastBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityBroadcastBinding = ActivityBroadcastBinding.inflate(LayoutInflater.from(this))
        setContentView(activityBroadcastBinding.root)
        localBroadcastManager = LocalBroadcastManager.getInstance(this)
        broadcastReceiver = MyBroadcastReceiver()
        activityBroadcastBinding.fabBroadcast.setOnClickListener {
            Intent("").also { intent ->
                intent.putExtra("message","This is the message")
                localBroadcastManager.sendBroadcast(intent)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        //IF YOU ARE REGISTERING THE BROADCAST RECEIVER IN ONRESUME METHOD THEN IT WILL UNREGISTER ONLY IN ONPAUSE METHOD
        //registering broadcast receiver from Here
        val intentFilter = IntentFilter().apply {
            addAction(Intent.ACTION_POWER_CONNECTED)
            addAction(Intent.ACTION_POWER_DISCONNECTED)
            addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        }
        //register receiver
        registerReceiver(broadcastReceiver, intentFilter)
        //register receiver for local message
        localBroadcastManager.registerReceiver(broadcastReceiver, IntentFilter("LOCAL_BROADCAST"))
    }

    override fun onPause() {
        super.onPause()
        //UNREGISTERING BROADCAST RECEIVER
        unregisterReceiver(broadcastReceiver)
        //UNREGISTERED LOCAL BROADCAST RECEIVER
        localBroadcastManager.unregisterReceiver(broadcastReceiver)
    }
}