package com.example.musicservice.util

import android.app.Activity
import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Binder
import android.os.Handler
import android.os.IBinder
import android.widget.Toast
import androidx.localbroadcastmanager.content.LocalBroadcastManager


class MusicService : Service() {

    var mediaPlayer : MediaPlayer ?= null
    var activity: Callbacks? = null
    private val mBinder: IBinder = MusicBinder()

    override fun onBind(intent: Intent?): IBinder? {
        return mBinder
    }

    inner class MusicBinder : Binder() {
        fun getService(): MusicService = this@MusicService
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        try {
            val uri = intent!!.extras?.get("Uri")
            mediaPlayer = MediaPlayer.create(this, Uri.parse(uri.toString()))
            mediaPlayer?.start()
            mediaPlayer!!.setOnCompletionListener(MediaPlayer.OnCompletionListener {
                val localBroadcastManager = LocalBroadcastManager.getInstance(this)
                val localIntent = Intent("FINISHED")
                localBroadcastManager.sendBroadcast(localIntent)
            })
            if(activity!=null){
                activity!!.updateClient()
            }
        }catch (e: Exception){
            val toast= Toast.makeText(this, "Error", Toast.LENGTH_SHORT)
            toast.show()
        }
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    fun registerClient(activity: Activity?) {
        this.activity = activity as Callbacks?
    }

    fun doUpdateClient(){
        activity!!.updateClient()
    }

    interface Callbacks {
        fun updateClient()
    }

}