package com.traversal.notestodo.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.traversal.notestodo.databinding.RowCompleteTaskBinding

class CompleteTaskAdapter(private val completeTask: MutableList<String>,val listener: (Int) -> Unit) : RecyclerView.Adapter<CompleteTaskAdapter.ViewHolder>() {

    private lateinit var binding: RowCompleteTaskBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = RowCompleteTaskBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        binding.tvComletedTask.text = completeTask[position]

        binding.llComletedTask.setOnClickListener {
            listener(position)
        }
    }

    override fun getItemCount(): Int {
        return completeTask.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
}