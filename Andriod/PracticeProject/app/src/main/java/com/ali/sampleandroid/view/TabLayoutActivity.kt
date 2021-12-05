package com.ali.sampleandroid.view

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.ali.sampleandroid.adapter.TabFragmentAdapter
import com.ali.sampleandroid.databinding.ActivityTabLayoutBinding

class TabLayoutActivity : AppCompatActivity(){

    lateinit var activityTabLayoutBinding: ActivityTabLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityTabLayoutBinding = ActivityTabLayoutBinding.inflate(LayoutInflater.from(this))
        setContentView(activityTabLayoutBinding.root)
        supportActionBar!!.hide()
        activityTabLayoutBinding.pagerTab.adapter = TabFragmentAdapter(supportFragmentManager)
        activityTabLayoutBinding.tabLayout.setupWithViewPager(activityTabLayoutBinding.pagerTab)
    }
}