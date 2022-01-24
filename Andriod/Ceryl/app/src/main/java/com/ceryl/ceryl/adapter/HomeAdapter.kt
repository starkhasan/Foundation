package com.ceryl.ceryl.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ceryl.ceryl.R
import com.ceryl.ceryl.network.response.course.Courses
import kotlinx.android.synthetic.main.row_home.view.*
import java.util.ArrayList

class HomeAdapter(var context: Context, var listCourse: List<Courses>, var listener: (String, Int) -> Unit) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.row_home,parent,false)
        return ViewHolder(view)
    }
    override fun getItemCount(): Int {
        return listCourse.size
    }
    override fun onBindViewHolder(holder:ViewHolder, position: Int) {
        holder.itemView.tvCourseName.setText(listCourse.get(position).course_name)
        holder.itemView.rlCourse.setBackgroundColor(Color.parseColor(listCourse.get(position).color))
        if(listCourse.get(position).course_type != "free")
            holder.itemView.ivCourseType.visibility = View.VISIBLE
        holder.itemView.rlCourse.setOnClickListener {
            listener(listCourse.get(position).course_name,position)
        }
    }
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){}
}