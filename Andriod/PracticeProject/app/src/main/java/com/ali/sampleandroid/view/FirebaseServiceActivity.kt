package com.ali.sampleandroid.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ali.sampleandroid.R
import com.ali.sampleandroid.databinding.ActivityFirebaseBinding
import com.ali.sampleandroid.utils.HelperUtils
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class FirebaseServiceActivity : AppCompatActivity(), View.OnClickListener{

    lateinit var firebaseLayout: ActivityFirebaseBinding
    private lateinit var auth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        firebaseLayout = ActivityFirebaseBinding.inflate(LayoutInflater.from(this))
        setContentView(firebaseLayout.root)
        auth = Firebase.auth
        firebaseLayout.btnLogin.setOnClickListener(this)

    }

    fun loginUser() {
        if(validationUser()){
            auth.signInWithEmailAndPassword(firebaseLayout.etEmail.text.toString(),firebaseLayout.etPassword.text.toString())
                .addOnCompleteListener(this){ task ->
                    if(task.isSuccessful){
                        HelperUtils.showToast(this,"User Login Successfully")
                    }else{
                        HelperUtils.showToast(this,"Failed to Login User")
                    }
                }
        }
    }

    fun logoutUser(){
        Firebase.auth.signOut()
        HelperUtils.showToast(this,"user Logout Successfully")
    }

    fun validationUser() : Boolean{
        if(firebaseLayout.etEmail.text.isBlank()){
            HelperUtils.showToast(this,"Please provide email")
            return false
        }else if(firebaseLayout.etPassword.text.isBlank()){
            HelperUtils.showToast(this,"Please provide passowrd")
            return false
        }else if(firebaseLayout.etPassword.text.length < 6){
            HelperUtils.showToast(this,"Weak Password!! Length of Password should be atleast 6")
        }
        return true
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnLogin -> {
                loginUser()
            }
        }
    }
}