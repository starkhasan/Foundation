package com.ali.virtualchat.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.HandlerCompat.postDelayed
import com.ali.virtualchat.R
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val animate = AnimationUtils.loadAnimation(applicationContext,R.anim.fade_in)
        rlAnimate.startAnimation(animate)

        animate.setAnimationListener(object: Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {}
            override fun onAnimationEnd(animation: Animation?) {
                navigate()
            }
            override fun onAnimationRepeat(animation: Animation?) {}
        })
    }

    fun navigate(){
        startActivity(Intent(this,LoginActivity::class.java))
        finish()
    }
}