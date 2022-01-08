package com.traversal.notestodo.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import com.traversal.notestodo.databinding.ActivityMainBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var splashLayout: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashLayout = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(splashLayout.root)

        val matrices = applicationContext.resources.displayMetrics
        val width = matrices.widthPixels
        val height = matrices.heightPixels

        splashLayout.ivSplashImage.layoutParams.height = height / 4
        splashLayout.ivSplashImage.layoutParams.width = width / 4

        Handler(Looper.getMainLooper()).postDelayed({
           startActivity(Intent(this,NotesHomeActivity::class.java))
            finish()
        },2000)
    }
}