package com.ali.sampleandroid.view.bottom_navigation

import android.R.attr
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.ali.sampleandroid.R
import com.ali.sampleandroid.databinding.ActivityBottomNavigationBinding
import com.ali.sampleandroid.fragment.FirstFragment
import com.ali.sampleandroid.fragment.SecondFragment
import com.ali.sampleandroid.fragment.ThirdFragment
import com.google.android.material.navigation.NavigationBarView


class BottomNavigationActivity : AppCompatActivity(){

    lateinit var activityBottomNavigationBinding: ActivityBottomNavigationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityBottomNavigationBinding = ActivityBottomNavigationBinding.inflate(
            LayoutInflater.from(
                this
            )
        )
        setContentView(activityBottomNavigationBinding.root)
        activityBottomNavigationBinding.bottomNavigation.setOnItemSelectedListener(
            navigationItemSelectedListener
        )
        //Setting Badges on BottomNavigationBarView
        val badge = activityBottomNavigationBinding.bottomNavigation.getOrCreateBadge(R.id.action_notification)
        badge.isVisible = true
        badge.number = 3
        //badge.isVisible = false   to make the Badge InVisible
        //badge.clearNumber()   to clear Number on Badge
        selectFragment(FirstFragment())
    }

    private fun selectFragment(fragment: Fragment){
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout, fragment)
        transaction.setReorderingAllowed(true)
        //transaction.addToBackStack(null)
        transaction.commit()
    }

    private var navigationItemSelectedListener = NavigationBarView.OnItemSelectedListener { item ->
        when(item.itemId){
            R.id.action_home -> {
                selectFragment(FirstFragment())
                true
            }
            R.id.action_message -> {
                selectFragment(SecondFragment())
                true
            }
            R.id.action_notification -> {
                selectFragment(ThirdFragment())
                true
            }
            else -> false
        }
    }
}