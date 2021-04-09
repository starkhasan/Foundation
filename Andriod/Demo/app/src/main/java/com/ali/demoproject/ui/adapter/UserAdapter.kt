package com.ali.demoproject.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ali.demoproject.R
import com.ali.demoproject.model.UserModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.row_user.view.*

class UserAdapter(var context: Context, val listUser: List<UserModel>?,val listener: (Int, String) -> Unit) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater.inflate(R.layout.row_user,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Picasso.get()
            .load(listUser?.get(position)!!.thumbnailUrl)
            .placeholder(R.drawable.progress_animation)
            .into(holder.itemView.ivUser)
        holder.itemView.ivUser.setOnClickListener{
            listener(position,"Click")
        }
    }

    override fun getItemCount(): Int {
        return listUser!!.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){}
}