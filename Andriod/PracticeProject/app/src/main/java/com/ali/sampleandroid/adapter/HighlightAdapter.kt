package com.ali.sampleandroid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ali.sampleandroid.databinding.RowHighlightBinding

class HighlightAdapter(private val  listHighlight: List<String>) : RecyclerView.Adapter<HighlightAdapter.ViewHolder>() {

    private var _binding: RowHighlightBinding?= null
    private val binding get() = _binding!!
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        _binding = RowHighlightBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        binding.tvHighlight.text = listHighlight[position]
    }

    override fun getItemCount(): Int {
        return listHighlight.size
    }

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view)
}