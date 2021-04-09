package com.ali.demoproject.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.ali.demoproject.ui.fragments.FirstFragment
import com.ali.demoproject.ui.fragments.SecondFragment

class ViewPagerAdapter(fm:FragmentManager) : FragmentStatePagerAdapter(fm){

    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment {
        var fragment : Fragment?=null
        when(position){
            0 ->{
                fragment = FirstFragment()
            }
            1 -> {
                fragment = SecondFragment()
            }
        }
        return fragment!!
    }

    override fun getPageTitle(position: Int): CharSequence? {
        var title:String?=null
        when(position){
            0 ->{
                title = "First"
            }
            1 -> {
                title = "Second"
            }
        }
        return title
    }

}