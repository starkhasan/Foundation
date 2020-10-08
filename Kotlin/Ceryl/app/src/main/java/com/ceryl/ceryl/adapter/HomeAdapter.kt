package com.ceryl.ceryl.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ceryl.ceryl.R
import kotlinx.android.synthetic.main.row_home.view.*
import java.util.ArrayList

class HomeAdapter(var context: Context,var listCourse: ArrayList<String>,var listColor: ArrayList<String>,var listener: (String, Int) -> Unit) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.row_home,parent,false)
        return ViewHolder(view)
    }
    override fun getItemCount(): Int {
        return listCourse.size
    }
    override fun onBindViewHolder(holder:ViewHolder, position: Int) {
        holder.itemView.tvCourseName.setText(listCourse.get(position))
        holder.itemView.rlCourse.setBackgroundColor(Color.parseColor(listColor.get(position)))

        holder.itemView.rlCourse.setOnClickListener {
            listener(listCourse[position],position)
        }
    }
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){}
}