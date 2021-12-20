package com.ali.sampleandroid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ali.sampleandroid.databinding.RowUserBinding
import com.ali.sampleandroid.model.response.UserResponse

class UserDetailsAdapter(private val listUser: List<UserResponse>,private val listener: (position: Int) -> Unit) : RecyclerView.Adapter<UserDetailsAdapter.ViewHolder>() {

    lateinit var binding: RowUserBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = RowUserBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        binding.tvUserTitle.text = listUser[position].title
        binding.llUserInfo.setOnClickListener{
            listener(position)
        }
    }

    override fun getItemCount(): Int {
        return listUser.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
}