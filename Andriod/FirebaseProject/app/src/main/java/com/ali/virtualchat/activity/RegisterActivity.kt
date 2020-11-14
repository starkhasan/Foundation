package com.ali.virtualchat.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.ali.virtualchat.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    val database = FirebaseDatabase.getInstance()
    var myRef = database.getReference().child("users")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btnRegister.setOnClickListener {
            if(validation()){
                val password = etPasswordRegister.text.toString()
                myRef.child(etEmailRegister.text.toString()).child("password").setValue(password.toInt())
                val intent = Intent(this,UserActivity::class.java)
                intent.putExtra("User",etEmailRegister.text.toString())
                startActivity(intent)
            }
        }
    }

    fun validation():Boolean{
        if(TextUtils.isEmpty(etEmailRegister.text)) {
            Toast.makeText(this, "Please provide UserID", Toast.LENGTH_SHORT).show()
            return false
        }else if(TextUtils.isEmpty(etPasswordRegister.text)){
            Toast.makeText(this,"Please provide password",Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }
}