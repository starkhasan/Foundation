package com.ali.sampleandroid.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ali.sampleandroid.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = FragmentSecondBinding.inflate(LayoutInflater.from(container!!.context),container,false)
        return view.root
    }
}