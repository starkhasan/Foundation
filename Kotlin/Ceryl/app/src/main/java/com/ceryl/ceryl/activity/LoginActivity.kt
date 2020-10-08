package com.ceryl.ceryl.activity

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.ceryl.ceryl.R
import com.ceryl.ceryl.app.ConnectivityReceiver
import com.ceryl.ceryl.app.RegisterAbstractActivity
import com.ceryl.ceryl.network.ApiCallService
import com.ceryl.ceryl.network.response.User.UserResponse
import com.ceryl.ceryl.util.*
import com.facebook.login.Login
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_login.*
import org.greenrobot.eventbus.Subscribe

class LoginActivity : RegisterAbstractActivity(){

    var appUser = AppUser()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LocalRepositories.saveAppUser(this,appUser)
        if(Preferences.isLogin){
            startActivity(Intent(LoginActivity@this,HomeActivity::class.java))
        }
        tvSignup.setOnClickListener {
            startActivity(Intent(LoginActivity@this,SignUpActivity::class.java))
        }
        rlLogin.setOnClickListener {
            Helper.hideKeyboard(LoginActivity@this)
            if(validation()){
                if(ConnectivityReceiver().isConnected()){
                    rotateloading.start()
                    appUser?.logindata?.put("password",etPassword.text.toString())
                    appUser?.logindata?.put("email",etEmail.text.toString())
                    LocalRepositories.saveAppUser(this,appUser)
                    ApiCallService.action(applicationContext, Cv.ACTION_LOGIN)
                }else{
                    Helper.snackbar_alert(LoginActivity@this,getString(R.string.no_internet_connection),rlLoginParent)
                }
            }
        }
        tvForgotPassword.setOnClickListener {
            startActivity(Intent(this,ForgotPasswordActivity::class.java))
        }
    }

    @Subscribe
    fun login(response:UserResponse){
        if(rotateloading.isStart){
            rotateloading.stop()
        }
        if(response.status == 200){
            Toast.makeText(applicationContext,response.message,Toast.LENGTH_SHORT).show()
            Preferences.isLogin = true
            Preferences.email = response.User.email
            Preferences.full_name = response.User.first_name +" "+response.User.last_name
            startActivity(Intent(LoginActivity@this,HomeActivity::class.java))
            finish()
        }else{
            Helper.snackbar_info(LoginActivity@this,response.message,rlLoginParent)
        }
    }

    private fun validation():Boolean{
        if(TextUtils.isEmpty(etEmail.text)){
            Helper.snackbar_alert(LoginActivity@this,"Please provide email",rlLoginParent)
            return false
        }else if(TextUtils.isEmpty(etPassword.text)){
            Helper.snackbar_alert(LoginActivity@this,"Please provide password",rlLoginParent)
            return false
        }
        return true
    }

    override fun layoutId(): Int {
        return R.layout.activity_login
    }

    @Subscribe
    fun timeout(msg: String) {
        if (rotateloading.isStart) {
            rotateloading.stop()
        }
        Helper.snackbar_alert(LoginActivity@this,Cv.TIMEOUT,rlLoginParent)
    }
}