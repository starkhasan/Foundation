package com.ali.tablayout.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.ali.tablayout.fragment.FirstFragment
import com.ali.tablayout.fragment.SecondFragment

class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        if(position == 0){
            fragment = FirstFragment()
        }else if(position == 1){
            fragment = SecondFragment()
        }
        return fragment!!
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        var title: String? = null
        if (position === 0) {
            title = "First"
        } else if (position === 1) {
            title = "Second"
        }
        return title
    }
}