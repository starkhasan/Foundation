package com.ali.virtualchat.activity

import android.content.Intent
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.ali.virtualchat.R
import com.ali.virtualchat.utils.Preferences
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Preferences.init(this@SplashActivity)

        val animate = AnimationUtils.loadAnimation(applicationContext,R.anim.fade_in)
        rlAnimate.startAnimation(animate)

        animate.setAnimationListener(object: Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {}
            override fun onAnimationEnd(animation: Animation?) {
                if(Preferences.is_login)
                    startActivity(Intent(this@SplashActivity,UserActivity::class.java))
                else
                    startActivity(Intent(this@SplashActivity,LoginActivity::class.java))
                finish()
            }
            override fun onAnimationRepeat(animation: Animation?) {}
        })
    }
}