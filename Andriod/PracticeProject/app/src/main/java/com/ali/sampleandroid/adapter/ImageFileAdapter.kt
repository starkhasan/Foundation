package com.ali.sampleandroid.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ali.sampleandroid.databinding.RowImageBinding
import com.ali.sampleandroid.model.ImageModel
import com.bumptech.glide.Glide
import java.text.DecimalFormat

class ImageFileAdapter(private val context : Context, private val listImages : List<ImageModel>) : RecyclerView.Adapter<ImageFileAdapter.ViewHolder>(){


    class ViewHolder(view : View) : RecyclerView.ViewHolder(view)

    private lateinit var binding: RowImageBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = RowImageBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(context)
            .asBitmap()
            .centerCrop()
            .load(listImages[position].url)
            .into(binding.ivImageThumbNail)

        binding.tvImageSize.text = calculateVideoSize(listImages[position].size)
    }

    override fun getItemCount(): Int {
        return listImages.size
    }

    fun calculateVideoSize(originalSize: Long) : String{
        val decimalFormat = DecimalFormat("0.00")
        val  tempSize = (originalSize/1024.0)/1024.0
        return decimalFormat.format(tempSize).plus(" MB")
    }
}