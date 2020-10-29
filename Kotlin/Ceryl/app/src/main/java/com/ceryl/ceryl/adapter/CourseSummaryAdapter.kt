package com.ceryl.ceryl.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ceryl.ceryl.R

class CourseSummaryAdapter : RecyclerView.Adapter<CourseSummaryAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseSummaryAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater.inflate(R.layout.row_course_summary,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {

    }

    override fun onBindViewHolder(holder: CourseSummaryAdapter.ViewHolder, position: Int) {

    }

    class ViewHolder(itemView: View) :  RecyclerView.ViewHolder(itemView){}
}