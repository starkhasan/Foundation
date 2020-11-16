package com.ali.virtualchat.activity

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ali.virtualchat.R
import com.ali.virtualchat.utils.*
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(){

    var database = FirebaseDatabase.getInstance()
    var myRef = database.getReference().child("users")
    var isLoginSuccessfull = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        Preferences.init(this@LoginActivity)


        if(Preferences.rememberme){
            cbRememberMe.isChecked = true
            etEmail.setText(Preferences.userid)
            etPassword.setText(Preferences.password)
        }else{
            cbRememberMe.isChecked = false
            etEmail.text.clear()
            etPassword.text.clear()
        }
        btnLogin.setOnClickListener {
            if(validation()){
                Preferences.rememberme = if(cbRememberMe.isChecked) true else false
                myRef.addValueEventListener(object: ValueEventListener{
                    override fun onDataChange(snapshot: DataSnapshot) {
                        for(data in snapshot.children){
                            if((etEmail.text.toString() == data.key.toString()) && (data.value as HashMap<Any,Any>)["password"].toString() == etPassword.text.toString()){
                                Preferences.userid = etEmail.text.toString()
                                Preferences.password = etPassword.text.toString()
                                isLoginSuccessfull = true
                                Preferences.sender = etEmail.text.toString()
                                startActivity(Intent(this@LoginActivity,UserActivity::class.java))
                                Toast.makeText(applicationContext,"Login Successfull",Toast.LENGTH_SHORT).show()
                            }
                        }

                        if(!isLoginSuccessfull)
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