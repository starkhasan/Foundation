package com.ali.sampleandroid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ali.sampleandroid.R
import com.ali.sampleandroid.databinding.RowHomeBinding

class HomeAdapter(
    private val listScreen: List<String>,
    private val listener: (position: Int) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var _binding: RowHomeBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        /*
        *Before view binding
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_home,parent,false)
        return ViewHolder(view)*/

        //Using view binding
        _binding =  RowHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        binding.tvTitle.text = listScreen[position]
        binding.llHomeRow.setOnClickListener {
            listener(position)
        }
    }

    override fun getItemCount(): Int {
        return listScreen.size
    }

//    class ViewHolder(rowHomeBinding: RowHomeBinding) : RecyclerView.ViewHolder(rowHomeBinding.root) {
//        private val rowHomeBinding: RowHomeBinding = rowHomeBinding
//
//    }
    class ViewHolder(rowHomeBinding: RowHomeBinding) : RecyclerView.ViewHolder(rowHomeBinding.root)
}