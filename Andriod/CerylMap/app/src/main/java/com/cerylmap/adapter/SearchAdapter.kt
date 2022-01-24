package com.cerylmap.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.cerylmap.R
import com.cerylmap.databinding.RowResultBinding

class SearchAdapter(var context: Context, var list: ArrayList<Any>, var listener: (Int, View) -> Unit) : RecyclerView.Adapter<SearchAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchAdapter.ViewHolder {
        var view=LayoutInflater.from(context).inflate(R.layout.row_result,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: SearchAdapter.ViewHolder, position: Int) {
        holder.binding?.tvResult?.setText(list.get(position).toString())
    }


    class ViewHolder(view: View) :RecyclerView.ViewHolder(view){
        var binding : RowResultBinding?
        init {
            binding=DataBindingUtil.bind(view)
        }
    }

}