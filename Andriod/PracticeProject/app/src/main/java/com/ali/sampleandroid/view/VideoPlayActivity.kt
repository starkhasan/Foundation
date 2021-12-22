package com.ali.sampleandroid.view

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.ali.sampleandroid.databinding.ActivityVideoPlayBinding
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer

class VideoPlayActivity : AppCompatActivity() {

    //obtaining reference of the view tree
    private val viewBinding by lazy(LazyThreadSafetyMode.NONE){
        ActivityVideoPlayBinding.inflate(LayoutInflater.from(this))
    }

    //creating exo player instance
    private var player:SimpleExoPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //set the view to the setContent view using view reference and call .root to get the view
        setContentView(viewBinding.root)
        val videoUri = intent.extras!!.get("VideoURI")
        //invoke method to initialize exo player instance
        initializePlayer(videoUri.toString())
    }

    private fun initializePlayer(videoUri: String){
        player = SimpleExoPlayer.Builder(this)
            .build()
            .also{ exoplayer ->
                //binding playe to its corresponding view
                viewBinding.videoView.player = exoplayer
                //creating media item
                val mediaItem = MediaItem.fromUri(Uri.parse(videoUri))
                exoplayer.setMediaItem(mediaItem)
                exoplayer.prepare()
                exoplayer.playWhenReady = true
            }
    }
}