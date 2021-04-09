package com.ali.demoproject.ui.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.Fragment
import com.ali.demoproject.R
import com.ali.demoproject.ui.adapter.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_viewpager.*
import kotlinx.android.synthetic.main.custom_toolbar.*

class ViewPagerActivity : AppCompatActivity(),View.OnClickListener{

    lateinit var viewPagerAdapter: ViewPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewpager)
        setToolbar()
        vpTab.adapter = ViewPagerAdapter(supportFragmentManager)
        tab.setupWithViewPager(vpTab)
    }

    fun setToolbar(){
        ivNav.setImageDrawable(getDrawable(R.drawable.icon_back))
        tvHeading.text = "View Pager"
        ivNav.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.ivNav ->{
                finish()
            }
        }
    }
}