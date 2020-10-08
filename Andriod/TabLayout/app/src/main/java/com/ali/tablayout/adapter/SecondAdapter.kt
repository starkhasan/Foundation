package com.ali.tablayout.adapter

import android.R
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager

class SecondAdapter(var activity: FragmentActivity?) : PagerAdapter(){

    private val sliderImageId = intArrayOf(
        R.drawable.ic_menu_compass,
        R.drawable.ic_delete,
        R.drawable.ic_dialog_alert,
        R.drawable.ic_dialog_info,
        R.drawable.ic_lock_idle_alarm
    )
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val imageView = ImageView(activity)
        imageView.setImageResource(sliderImageId[position])
        imageView.setOnClickListener {

        }
        (container as ViewPager).addView(imageView, 0)
        return imageView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        (container as ViewPager).removeView(`object` as ImageView)
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as ImageView
    }

    override fun getCount(): Int {
        return sliderImageId.size
    }
}