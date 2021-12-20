package com.ali.sampleandroid.view

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.ali.sampleandroid.databinding.ActivityThreadBinding

class ThreadExampleActivity : AppCompatActivity(){

    lateinit var threadLayout: ActivityThreadBinding
    var i = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        threadLayout = ActivityThreadBinding.inflate(LayoutInflater.from(this))
        setContentView(threadLayout.root)

        threadLayout.btnStartThread.setOnClickListener{
            //example of runOnUiThread
            Thread {
                while (i++ < 10){
                    runOnUiThread{
                        threadLayout.tvThreadCount.text = "Thread Count : $i"
                    }
                    Thread.sleep(1000)
                }
                if(i == 10) i=0
            }.start()
        }
    }
}