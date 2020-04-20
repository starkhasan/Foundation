package com.ceryl.ceryl.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ceryl.ceryl.activity.MainActivity
import com.ceryl.ceryl.R
import com.ceryl.ceryl.databinding.RowMusicBinding

class MusicAdapter(var mainActivity: MainActivity, var arrayList: ArrayList<String>) : RecyclerView.Adapter<MusicAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicAdapter.ViewHolder {
        val view=LayoutInflater.from(mainActivity).inflate(R.layout.row_music,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: MusicAdapter.ViewHolder, position: Int) {
        holder.binding?.tvImageName?.setText(arrayList.get(position))
    }

    class ViewHolder(view:View) : RecyclerView.ViewHolder(view){
        val binding:RowMusicBinding?
        init {
            binding=DataBindingUtil.bind(itemView)
        }
    }
}