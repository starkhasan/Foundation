package com.ali.virtualchat.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ali.virtualchat.R
import com.ali.virtualchat.activity.UserActivity
import kotlinx.android.synthetic.main.row_user.view.*

class UserAdapter(val context: Context,val listUser: ArrayList<String>, val listener: (Int, String) -> Unit) : RecyclerView.Adapter<UserAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater.inflate(R.layout.row_user,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserAdapter.ViewHolder, position: Int) {
        holder.itemView.tvUser.text = listUser[position]
        holder.itemView.tvUser.setOnClickListener {
            listener(position,"Chat")
        }
    }

    override fun getItemCount(): Int {
        return listUser.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){}
}