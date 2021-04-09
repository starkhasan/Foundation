package com.ali.demoproject.ui.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.ali.demoproject.R
import kotlinx.android.synthetic.main.custom_toolbar.*

class AppLifeCycleActivity : AppCompatActivity(), View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_applifecycle)
        settoolbar()
        Log.v("Activity","onCreate")
    }

    fun settoolbar(){
        tvHeading.text = "App Life Cycle"
        ivNav.setImageDrawable(getDrawable(R.drawable.icon_back))
        ivNav.setOnClickListener(this)
    }

    override fun onStart() {
        super.onStart()
        Log.v("Activity","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.v("Activity","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.v("Activity","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.v("Activity","onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v("Activity","onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.v("Activity","onRestart")
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.ivNav ->{
                finish()
            }
        }
    }

}