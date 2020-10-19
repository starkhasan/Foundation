package com.ceryl.ceryl.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.ceryl.ceryl.R
import com.ceryl.ceryl.activity.CourseSummaryActivity
import kotlinx.android.synthetic.main.row_course.view.*

class CourseContentAdapter(val context: CourseSummaryActivity,val courseList: ArrayList<String>,val courseContentList: ArrayList<String>) :RecyclerView.Adapter<CourseContentAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseContentAdapter.ViewHolder {
        var layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater.inflate(R.layout.row_course,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CourseContentAdapter.ViewHolder, position: Int) {
        holder.itemView.tvTitle.text = courseList[position]
        holder.itemView.tvContent.text = courseContentList[position]

        holder.itemView.ivExpand.setOnClickListener {
            if(holder.itemView.tvContent.visibility == View.VISIBLE){
                holder.itemView.ivExpand.setImageResource(R.drawable.icon_add)
                holder.itemView.tvContent.visibility = View.GONE
            }else{
                holder.itemView.ivExpand.setImageResource(R.drawable.icon_minus)
                holder.itemView.tvContent.visibility = View.VISIBLE
            }
        }
    }

    override fun getItemCount(): Int {
        return courseList.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){}
}