package com.traversal.notestodo.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.traversal.notestodo.databinding.RowTaskBinding

class TaskAdapter(private val listTask: MutableList<String>,val listener: (Int) -> Unit) : RecyclerView.Adapter<TaskAdapter.ViewHolder>(){

    private lateinit var binding: RowTaskBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = RowTaskBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        binding.tvTask.text = listTask[position]

        binding.llTask.setOnClickListener {
            listener(position)
        }
    }

    override fun getItemCount(): Int {
        return listTask.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
}