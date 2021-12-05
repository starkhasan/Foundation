package com.ali.sampleandroid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ali.sampleandroid.databinding.RowDynamicBinding

class DynamicAdapter(private val listTask: List<String>,private val listener: (Int) -> Unit) : RecyclerView.Adapter<DynamicAdapter.ViewHolder>(){

    private var _binding: RowDynamicBinding ?= null
    private val binding get() = _binding!!

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        _binding = RowDynamicBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        binding.tvTask.text = listTask[position]
        binding.ivDeleteTask.setOnClickListener{
            listener(position)
        }
    }

    override fun getItemCount(): Int {
        return listTask.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
}