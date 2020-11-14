package com.example.musicservice.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.musicservice.R
import com.example.musicservice.activity.VideoPlayerActivity
import com.example.musicservice.response.VideoModel
import kotlinx.android.synthetic.main.row_video.view.*

class VideoAdapter(val content: Context,val videoList: ArrayList<VideoModel>,val listener: (Int, String, String) -> Unit) : RecyclerView.Adapter<VideoAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(content)
        val view = layoutInflater.inflate(R.layout.row_video,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: VideoAdapter.ViewHolder, position: Int) {
        holder.itemView.tvVideoName.text = videoList[position].title
        holder.itemView.llVideo.setOnClickListener {
            listener(position,videoList[position].uri,"Play")
        }
    }

    override fun getItemCount(): Int {
        return videoList.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){}

}