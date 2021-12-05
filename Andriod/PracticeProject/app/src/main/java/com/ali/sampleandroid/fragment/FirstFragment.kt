package com.ali.sampleandroid.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ali.sampleandroid.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = FragmentFirstBinding.inflate(LayoutInflater.from(container!!.context),container,false)
        return view.root
    }

}