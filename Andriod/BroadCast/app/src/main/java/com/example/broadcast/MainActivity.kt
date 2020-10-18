package com.example.broadcast

import android.content.BroadcastReceiver
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe


class MainActivity : AppCompatActivity() {
    val br: BroadcastReceiver = MyBroadcastReceiver()
    var intentFilter: IntentFilter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        intentFilter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
    }

    @Subscribe
    fun getConnection(event: MessageEvent) {
        if(event.message == "true")
            tvTExt.text = "Connected"
        else
            tvTExt.text = "No Connection"
    }


    override fun onResume() {
        super.onResume()
        registerReceiver(br, intentFilter)
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(br)
    }

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        EventBus.getDefault().unregister(this)
        super.onStop()
    }
}
