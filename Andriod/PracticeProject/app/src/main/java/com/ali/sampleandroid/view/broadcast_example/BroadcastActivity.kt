package com.ali.sampleandroid.view.broadcast_example

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.ali.sampleandroid.broadcast.MyBroadcastReceiver
import com.ali.sampleandroid.databinding.ActivityBroadcastBinding
import com.ali.sampleandroid.network.ApiService
import com.ali.sampleandroid.network.response.UserResponse
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

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
//            Intent("").also { intent ->
//                intent.putExtra("message","This is the message")
//                localBroadcastManager.sendBroadcast(intent)
//            }
            if(checkConnection()) {
                getUserData()
            }else
                Toast.makeText(this,"Not Connected",Toast.LENGTH_SHORT).show()
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

    private fun checkConnection() : Boolean{
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            val networkInfo =  connectivityManager.activeNetwork ?: return false
            val actNetwork = connectivityManager.getNetworkCapabilities(networkInfo)!!
            return when{
                actNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                actNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                actNetwork.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                else -> false
            }
        }else{
            connectivityManager.allNetworks.forEach{ network ->
                val networkInfo = connectivityManager.getNetworkInfo(network)
                return (networkInfo!!.type == ConnectivityManager.TYPE_WIFI || networkInfo.type == ConnectivityManager.TYPE_MOBILE) && networkInfo.isConnectedOrConnecting
            }
        }
        return false
    }

    private fun getUserData(){
        val client = ApiService.retroClient()
        client.getUser().enqueue(object: retrofit2.Callback<List<UserResponse>> {
            override fun onResponse(call: Call<List<UserResponse>>,response: Response<List<UserResponse>>) {
                Toast.makeText(applicationContext,"Sucsess",Toast.LENGTH_SHORT).show()
                if(response.body() != null){
                    val userResponse : List<UserResponse>? = response.body()
                    Toast.makeText(applicationContext,"Total User Response Size => ${userResponse!!.size}",Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<List<UserResponse>>, t: Throwable) {
                Toast.makeText(applicationContext,"Failed",Toast.LENGTH_SHORT).show()
            }
        })
    }
}