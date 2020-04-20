package com.ceryl.ceryl.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ceryl.ceryl.R
import com.ceryl.ceryl.activity.SecondActivity
import com.ceryl.ceryl.databinding.RowPositionBinding

class PositionAdapter(var secondActivity: SecondActivity,var listName: ArrayList<String>) : RecyclerView.Adapter<PositionAdapter.ViewHolder>() {

    var selectposititon:Int=0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PositionAdapter.ViewHolder {
        var view = LayoutInflater.from(secondActivity).inflate(R.layout.row_position,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listName.size
    }

    override fun onBindViewHolder(holder: PositionAdapter.ViewHolder, position: Int) {
        holder.binding?.tvData?.setText(listName.get(position))


        //Single Selection in RecyclerView Android
        holder.binding?.cdPosition?.isChecked = position==selectposititon

        holder.binding?.rlSelect?.setOnClickListener{
            holder.binding?.cdPosition?.isChecked=true
            selectposititon=position
            notifyDataSetChanged()
        }


        /*
        //Multiple Selection in Recycler View Android
        holder.binding?.rlSelect?.setOnClickListener {
            if(holder.binding?.cdPosition?.isChecked==true){
                holder.binding?.cdPosition?.isChecked=false
            }else{
                holder.binding?.cdPosition?.isChecked=true
            }
        }
        */

    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var binding:RowPositionBinding?
        init {
            binding=DataBindingUtil.bind(view)
        }
    }
}