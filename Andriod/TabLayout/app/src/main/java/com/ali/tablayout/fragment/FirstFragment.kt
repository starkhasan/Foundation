package com.ali.tablayout.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ali.tablayout.R
import com.ali.tablayout.adapter.FirstAdapter
import kotlinx.android.synthetic.main.fragment_first.*

class FirstFragment : Fragment() {

    var petList = ArrayList<String>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_first,container,false)
        val recyclerView:RecyclerView = view.findViewById(R.id.rvFirst)
        for (i in 1..50){
            petList.add("India")
        }
        val linearLayoutManager = LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false)
        recyclerView.layoutManager = linearLayoutManager

        recyclerView.adapter = FirstAdapter(activity,petList){position:Int,OPERATION:String ->
            if(OPERATION == "Clicked")
                Toast.makeText(activity,position.toString(),Toast.LENGTH_SHORT).show()
        }
        return view
    }
}