package com.ali.virtualchat.activity

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.ali.virtualchat.R
import com.ali.virtualchat.utils.Helper
import com.ali.virtualchat.utils.Preferences
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    val database = FirebaseDatabase.getInstance()
    var myRef = database.getReference().child("users")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_register)
        Preferences.init(this@RegisterActivity)

        btnRegister.setOnClickListener {
            Helper.hideKeyboard(this@RegisterActivity)
            if(validation()){
                val password = etPasswordRegister.text.toString()
                myRef.child(etEmailRegister.text.toString()).child("password").setValue(password.toInt())
                Preferences.sender = etEmailRegister.text.toString()
                Preferences.is_login = true
                val intent = Intent(this,UserActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
                finish()
            }
        }

        tvLoginUser.setOnClickListener {
            if(intent.extras!=null && intent.extras!!.get("From") == "UserActivity"){
                startActivity(Intent(this@RegisterActivity,LoginActivity::class.java))
                finish()
            }else{
                finish()
            }
        }
    }

    fun validation():Boolean{
        if(!Helper.isNetworkConnected(this@RegisterActivity)){
            AlertDialog.Builder(this,R.style.AlertDialogTheme)
                .setMessage(R.string.no_internet_connection)
                .setPositiveButton(R.string.ok){ dialog: DialogInterface, int:Int ->
                    dialog.dismiss()
                }
                .show()
            return false
        }else if(TextUtils.isEmpty(etEmailRegister.text)) {
            Toast.makeText(this, "Please provide UserID", Toast.LENGTH_SHORT).show()
            return false
        }else if(TextUtils.isEmpty(etPasswordRegister.text)){
            Toast.makeText(this,"Please provide password",Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }
}