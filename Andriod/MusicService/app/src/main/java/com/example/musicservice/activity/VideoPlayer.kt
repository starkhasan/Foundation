package com.example.musicservice.activity

import android.media.MediaPlayer
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.widget.MediaController
import androidx.appcompat.app.AppCompatActivity
import com.example.musicservice.R
import kotlinx.android.synthetic.main.layout_video_player.*

class VideoPlayer : AppCompatActivity() {

    private val VIDEO_SAMPLE = "video_test"
    private var mCurrentPosition = 0
    private val PLAYBACK_TIME = "play_time"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_video_player)
        val mediaController = MediaController(this)
        mediaController.setMediaPlayer(videoview)
        videoview.setMediaController(mediaController)
        if(savedInstanceState!=null){
            mCurrentPosition = savedInstanceState.getInt(PLAYBACK_TIME)
        }
        initializePlayer()
    }

    private fun getMedia(mediaName: String): Uri {
        return Uri.parse("android.resource://" + getPackageName() + "/raw/" + mediaName)
    }

    private fun initializePlayer(){
        val videoUri = getMedia(VIDEO_SAMPLE)
        videoview.setVideoURI(videoUri)
        if (mCurrentPosition > 0) {
            videoview.seekTo(mCurrentPosition)
        } else {
            videoview.seekTo(1)
        }
        videoview.start()
        videoview.setOnPreparedListener(object : MediaPlayer.OnPreparedListener {
            override fun onPrepared(mp: MediaPlayer?) {
                mp!!.isLooping = false
            }
        })
    }


    private fun releasePlayer(){
        videoview.stopPlayback()
    }

    override fun onStop() {
        super.onStop()
        releasePlayer()
    }

    override fun onPause() {
        super.onPause()
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.N)
            videoview.pause()
        mCurrentPosition = videoview.currentPosition
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(PLAYBACK_TIME,mCurrentPosition)
    }
}