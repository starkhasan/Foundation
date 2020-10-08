package com.ali.tablayout.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ali.tablayout.R
import com.ali.tablayout.adapter.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewpagerAdater:ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewpagerAdater = ViewPagerAdapter(supportFragmentManager)
        vpTab.adapter = viewpagerAdater
        tab.setupWithViewPager(vpTab)
    }
}