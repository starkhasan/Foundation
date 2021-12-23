package com.ali.sampleandroid.view

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.ali.sampleandroid.R
import com.ali.sampleandroid.databinding.ActivityVideoPlayBinding
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.util.Util
import com.google.gson.annotations.Until

class VideoPlayActivity : AppCompatActivity() {

    //obtaining reference of the view tree
    private val viewBinding by lazy(LazyThreadSafetyMode.NONE){
        ActivityVideoPlayBinding.inflate(LayoutInflater.from(this))
    }

    //creating exo player instance
    private var player:SimpleExoPlayer? = null
    private var videoUri = ""
    private var videoTitle: String = ""
    private var playWhenReady = true
    private var currentWindow = 0
    private var playbackPosition = 0L
    private val PLAYBACK_TIME = "play_time"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //set the view to the setContent view using view reference and call .root to get the view
        setContentView(viewBinding.root)
        videoUri = intent.extras!!.get("VideoURI").toString()
        videoTitle = intent.extras!!.get("VideoTitle").toString()
        //invoke method to initialize exo player instance
        if(savedInstanceState!=null){
            playbackPosition = savedInstanceState.getLong(PLAYBACK_TIME)
        }
    }

    override fun onResume() {
        super.onResume()
        Log.v("Video Life Cycle","Resumed")
        hideSystemUi()
        if((Util.SDK_INT < 24|| player == null)){
            initializePlayer(videoUri)
        }
    }

    public override fun onPause() {
        super.onPause()
        Log.v("Video Life Cycle","Paused")
        if (Util.SDK_INT < 24) {
            releasePlayer()
        }
    }


    public override fun onStop() {
        super.onStop()
        Log.v("Video Life Cycle","Stop")
        if (Util.SDK_INT >= 24) {
            releasePlayer()
        }
    }

    private fun releasePlayer() {
        player?.run {
            playbackPosition = this.currentPosition
            currentWindow = this.currentWindowIndex
            playWhenReady = this.playWhenReady
            release()
        }
        player = null
    }


    private fun hideSystemUi(){
        viewBinding.videoView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LOW_PROFILE
                or View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)
    }

    private fun initializePlayer(videoUri: String){
        player = SimpleExoPlayer.Builder(this)
            .build()
            .also{ exoplayer ->
                //binding playe to its corresponding view
                viewBinding.videoView.player = exoplayer
                val videoTitleText = viewBinding.videoView.findViewById<TextView>(R.id.tvVideoTitle)
                videoTitleText.text = videoTitle
                //creating media item
                val mediaItem = MediaItem.fromUri(Uri.parse(videoUri))
                exoplayer.setMediaItem(mediaItem)
                exoplayer.playWhenReady = playWhenReady
                exoplayer.seekTo(currentWindow, playbackPosition)
                exoplayer.prepare()
            }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if(player != null) {
            outState.putLong(PLAYBACK_TIME, player!!.currentPosition)
        }
    }

}