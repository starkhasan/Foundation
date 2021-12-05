package com.ali.sampleandroid.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.ali.sampleandroid.fragment.FirstFragment
import com.ali.sampleandroid.fragment.SecondFragment

class TabFragmentAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm){
    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = FirstFragment()
            1 -> fragment = SecondFragment()
        }
        return fragment!!
    }

    override fun getPageTitle(position: Int): CharSequence? {
        var title: String? = null
        when {
            position == 0 -> {
                title = "First"
            }
            position == 1 -> {
                title = "Second"
            }
        }
        return title
    }
}