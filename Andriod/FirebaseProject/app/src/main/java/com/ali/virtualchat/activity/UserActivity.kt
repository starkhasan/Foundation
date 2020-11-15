package com.ali.virtualchat.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ali.virtualchat.R
import com.ali.virtualchat.adapter.UserAdapter
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_user.*

class UserActivity : AppCompatActivity(){

    val database = FirebaseDatabase.getInstance()
    val myRef = database.getReference().child("users")
    val listUser = ArrayList<String>()
    var userAdapter : UserAdapter ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        val currentUser = intent.extras!!.get("User")

        myRef.addValueEventListener(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                listUser.clear()
                for(data in snapshot.children){
                    if(data.key.toString() != currentUser){
                        listUser.add(data.key.toString())
                    }
                }

                val linearLayoutManager = LinearLayoutManager(this@UserActivity,LinearLayoutManager.VERTICAL,false)
                rvUser.layoutManager = linearLayoutManager
                userAdapter = UserAdapter(this@UserActivity,listUser){position:Int,OPERATION:String ->
                    if(OPERATION == "Chat"){
                        val chatWith = currentUser.toString()+"_"+listUser[position]
                        val intent = Intent(this@UserActivity,Chat::class.java)
                        intent.putExtra("Chat",chatWith)
                        startActivity(intent)
                    }
                }
                rvUser.adapter = userAdapter
            }
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(applicationContext,"Couldn't get the user",Toast.LENGTH_SHORT).show()
            }
        })
    }
}