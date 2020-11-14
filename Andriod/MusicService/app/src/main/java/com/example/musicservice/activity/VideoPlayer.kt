package com.example.musicservice.activity

import android.media.MediaPlayer
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.webkit.URLUtil
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.example.musicservice.R
import kotlinx.android.synthetic.main.layout_video_player.*

class VideoPlayer : AppCompatActivity() {

    private val VIDEO_SAMPLE = "video_test"
    private val ONLINE_VIDEO_SAMPLE = "https://developers.google.com/training/images/tacoma_narrows.mp4";
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
        //UnComment this For Playing Online Video
        /*if(URLUtil.isValidUrl(mediaName)){
            return Uri.parse(mediaName)
        }else{
            return Uri.parse("android.resource://" + getPackageName() + "/raw/" + mediaName)
        }*/
        return Uri.parse(intent.extras!!.get("url") as String?)//For Offline Video
    }

    private fun initializePlayer(){
        val videoUri = getMedia(ONLINE_VIDEO_SAMPLE)
        //buffering_textview.setVisibility(VideoView.VISIBLE)
        newton_cradle_loading.start()
        videoview.setVideoURI(videoUri)

        videoview.setOnPreparedListener(object : MediaPlayer.OnPreparedListener {
            override fun onPrepared(mp: MediaPlayer?) {
                newton_cradle_loading.setVisibility(VideoView.INVISIBLE)
                if (mCurrentPosition > 0) {
                    videoview.seekTo(mCurrentPosition);
                } else {
                    videoview.seekTo(1);
                }
                videoview.start()
                mp!!.isLooping = true
            }
        })

        videoview.setOnErrorListener(MediaPlayer.OnErrorListener { mp, what, extra ->
            buffering_textview.setVisibility(VideoView.GONE)
            false
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
        outState.putInt(PLAYBACK_TIME, mCurrentPosition)
    }
}