package com.ali.tablayout.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.ali.tablayout.R
import kotlinx.android.synthetic.main.row_first.view.*

class FirstAdapter(var firstFragment: FragmentActivity?,var petList: ArrayList<String>,var listener: (Int, String) -> Unit) : RecyclerView.Adapter<FirstAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FirstAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(firstFragment)
        val view = layoutInflater.inflate(R.layout.row_first,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return petList.size
    }

    override fun onBindViewHolder(holder: FirstAdapter.ViewHolder, position: Int) {
        holder.itemView.tvFirst.text = petList[position]

        holder.itemView.llFirst.setOnClickListener {
            listener(position,"Clicked")
        }
    }
}