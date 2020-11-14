package com.ali.virtualchat.activity

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ali.virtualchat.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*

class LoginActivity : AppCompatActivity(){

    var database = FirebaseDatabase.getInstance()
    var myRef = database.getReference().child("users")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener {
            if(validation()){
                myRef.addValueEventListener(object: ValueEventListener{
                    override fun onDataChange(snapshot: DataSnapshot) {
                        for(data in snapshot.children){
                            if((etEmail.text.toString() == data.key.toString()) && (data.value as HashMap<Any,Any>)["password"].toString() == etPassword.text.toString()){
                                val intent = Intent(this@LoginActivity,UserActivity::class.java)
                                intent.putExtra("User",etEmail.text.toString())
                                startActivity(intent)
                                Toast.makeText(applicationContext,"Login Successfull",Toast.LENGTH_SHORT).show()
                            }
                        }
                        Toast.makeText(applicationContext,"Invalid UserID and Password",Toast.LENGTH_SHORT).show()
                    }
                    override fun onCancelled(error: DatabaseError) {
                        Toast.makeText(applicationContext,"Failed to read value",Toast.LENGTH_SHORT).show()
                    }
                })
            }
        }

        tvRegisterUser.setOnClickListener {
            startActivity(Intent(this,RegisterActivity::class.java))
        }

    }

    fun validation():Boolean{
        if(TextUtils.isEmpty(etEmail.text)){
            Toast.makeText(this,"Enter user id",Toast.LENGTH_SHORT).show()
            return false
        }else if(TextUtils.isEmpty(etPassword.text)){
            Toast.makeText(this,"Enter password",Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }
}