package com.ceryl.ceryl.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ceryl.ceryl.R
import com.ceryl.ceryl.network.response.course_content.Content
import kotlinx.android.synthetic.main.row_course_summary.view.*
import java.util.ArrayList

class CourseSummaryAdapter(val context: Context,val listContent: ArrayList<Content>,val listener: (String, Int) -> Unit) : RecyclerView.Adapter<CourseSummaryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater.inflate(R.layout.row_course_summary,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val summary = listContent[position].content
        val listSummary = summary.split("[")
        holder.itemView.tvTitle.text = listSummary[0]
        holder.itemView.tvSummary.text = listSummary[1]
    }

    override fun getItemCount(): Int {
        return listContent.size
    }

    class ViewHolder(itemView: View) :  RecyclerView.ViewHolder(itemView){}
}