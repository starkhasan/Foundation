package com.ali.tablayout.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.ali.tablayout.R
import com.ali.tablayout.adapter.SecondAdapter
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class SecondFragment : Fragment(){

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_second,container,false)
        val viewPager:ViewPager = view.findViewById(R.id.vpSeond);
        val secondAdapter = SecondAdapter(activity)
        viewPager.adapter = secondAdapter

        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {}
            override fun onPageScrolled(position: Int,positionOffset: Float,positionOffsetPixels: Int) {}
            override fun onPageSelected(position: Int) {

            }
        })

        return view
    }

}
