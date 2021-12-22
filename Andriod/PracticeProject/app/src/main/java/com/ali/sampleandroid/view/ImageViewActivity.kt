package com.ali.sampleandroid.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import androidx.appcompat.app.AppCompatActivity
import com.ali.sampleandroid.databinding.ActivityImageViewBinding
import com.bumptech.glide.Glide

class ImageViewActivity : AppCompatActivity(){

    private lateinit var scaleGestureDetector: ScaleGestureDetector
    var scaleFactor = 1.0f
    private lateinit var imageLayout: ActivityImageViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        imageLayout = ActivityImageViewBinding.inflate(LayoutInflater.from(this))
        setContentView(imageLayout.root)
        val imageUri = intent.extras!!.get("ImageURI")
        Glide.with(this)
                .asBitmap()
                .load(imageUri)
                .into(imageLayout.ivImage)
        scaleGestureDetector = ScaleGestureDetector(this,ScaleListener())
    }

    //this redirect all touch event in the Activity to gesture detector
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return scaleGestureDetector.onTouchEvent(event)
    }

    inner class ScaleListener : ScaleGestureDetector.OnScaleGestureListener{
        override fun onScale(detector: ScaleGestureDetector?): Boolean {
            if(scaleFactor in 1.0..3.0) {
                scaleFactor *= detector!!.scaleFactor
                imageLayout.ivImage.scaleX = scaleFactor
                imageLayout.ivImage.scaleY = scaleFactor
                if(scaleFactor < 1.0) scaleFactor = 1.0f
                if(scaleFactor > 3.0) scaleFactor = 3.0f
            }
            return true
        }
        override fun onScaleBegin(detector: ScaleGestureDetector?): Boolean {
            return true
        }
        override fun onScaleEnd(detector: ScaleGestureDetector?) {}
    }
}