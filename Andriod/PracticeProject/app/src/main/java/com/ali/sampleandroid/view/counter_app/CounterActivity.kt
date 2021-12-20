package com.ali.sampleandroid.view.counter_app

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ali.sampleandroid.databinding.ActivityCounterBinding

class CounterActivity : AppCompatActivity(){

    lateinit var activityCounterBinding: ActivityCounterBinding
    lateinit var model: CounterModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityCounterBinding = ActivityCounterBinding.inflate(LayoutInflater.from(this))
        setContentView(activityCounterBinding.root)

        model = ViewModelProvider(this).get(CounterModel::class.java)

        activityCounterBinding.fabCounter.setOnClickListener{
            model.increment()
        }

        model.getData().observe(this,Observer<Int>(){ data ->
            activityCounterBinding.tvCounter.text = data.toString()
        })
    }
}