package com.example.musicservice.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.musicservice.R
import kotlinx.android.synthetic.main.activity_videoplayer.*

class VideoPlayerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_videoplayer)

        ivMusic.setOnClickListener {
            finish()
        }

        btnPlay.setOnClickListener {
            startActivity(Intent(this,VideoPlayer::class.java))
        }
    }

}