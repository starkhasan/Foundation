package com.ali.virtualchat.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ali.virtualchat.R
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase


class Chat : AppCompatActivity(){

    val database = FirebaseDatabase.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
    }
}