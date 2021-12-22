package com.ali.sampleandroid.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ali.sampleandroid.databinding.RowVideoBinding
import com.ali.sampleandroid.model.VideoModel
import com.bumptech.glide.Glide
import java.text.DecimalFormat

class VideoFileAdapter(private val context: Context, private val listVideos: List<VideoModel>,private val listener: (Int) -> Unit) : RecyclerView.Adapter<VideoFileAdapter.ViewHolder>(){

    lateinit var binding: RowVideoBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = RowVideoBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(context)
            .asBitmap()
            .centerCrop()
            .load(listVideos[position].url)
            .into(binding.ivVideoThumbNail)
        binding.tvVideoSize.text = calculateVideoSize(listVideos[position].videoSize)
        binding.rlVideo.setOnClickListener{
            listener(position)
        }
    }

    override fun getItemCount(): Int {
        return listVideos.size
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view)

    fun calculateVideoSize(originalSize: Long) : String{
        val decimalFormat = DecimalFormat("0.00")
        val  tempSize = (originalSize/1024.0)/1024.0
        return decimalFormat.format(tempSize).plus(" MB")
    }

}