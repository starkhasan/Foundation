package com.ali.sampleandroid.view.counter_app

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterModel : ViewModel(){
    var count = 0
    private val counter = MutableLiveData(count)
    fun increment(){
        count++
        counter.value = count
    }

    fun getData() : LiveData<Int>{
        return counter
    }
}